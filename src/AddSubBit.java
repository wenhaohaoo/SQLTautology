import java.util.HashMap;
import java.util.Iterator;

public class AddSubBit {

	private Float val = (float) 0;
	private String str;
	private String op;
	private String result = "";
	private HashMap<String, Float> varList;
	private HashMap<String, AddSubBit> varListNumerator;
	private boolean isStrOp;
	private Term prevTerm;

	enum Term {
		NUMBER, VAR, STRING
	}

	public AddSubBit(String x, boolean hasString) {
		varList = new HashMap<String, Float>();
		varListNumerator = new HashMap<String, AddSubBit>();
		isStrOp = hasString;
		if (ExpressionHelper.isValidNumber(x)) {
			prevTerm = Term.NUMBER;
			val = Float.parseFloat(x);
		} else if (ExpressionHelper.isValidVariable(x)) {
			prevTerm = Term.VAR;
			varList.put(x, (float) 1);
		} else if (ExpressionHelper.isValidString(x)) {
			prevTerm = Term.STRING;
			str = x;
		} else {
			prevTerm = Term.VAR;
			if (x.contains("*")) {
				int index = x.indexOf("*");
				if (ExpressionHelper.isValidNumber(x.substring(0, index))
						&& ExpressionHelper.isValidVariable(x.substring(index + 1))) {
					varList.put((x.substring(index + 1)), Float.parseFloat(x.substring(0, index)));
				}
			} else if (x.contains("/") && !x.contains("%")) {
				int index = x.indexOf("/");
				String var = x.substring(index);
				String coeff = x.substring(0, index);

				if (varList.containsKey(var)) {
					varListNumerator.get(var).append(op);
					varListNumerator.get(var).append(coeff);
				} else {
					varList.put(var, (float) 1);
					varListNumerator.put(var, new AddSubBit(coeff, false));
				}
			} else {
				varList.put(x, (float) 1);
			}
		}
	}

	public void append(String nextToken) {
		nextToken = nextToken.trim();
		Term current = null;
		if (nextToken.matches("\\+|-|&|\\|")) {
			this.op = nextToken;
			current = null;
		} else if (ExpressionHelper.isValidNumber(nextToken)) {
			current = Term.NUMBER;
		} else if (ExpressionHelper.isValidString(nextToken)) {
			current = Term.STRING;
		} else {
			current = Term.VAR;
		}

		switch (prevTerm) {

		case NUMBER:
			if (current == Term.NUMBER) {
				if (this.op.equals("+")) {
					this.val = this.val + Float.parseFloat(nextToken);
				} else if (this.op.equals("-")) {
					this.val = this.val - Float.parseFloat(nextToken);
				} else if (this.op.equals("&")) {

				} else if (this.op.equals("|")) {

				}
				prevTerm = Term.NUMBER;
			} else if (current == null) {
				// do nothing
			} else {
				
				if (nextToken.contains("*")) {
					int index = nextToken.indexOf("*");
					String var = nextToken.substring(index + 1);
					String coeff = nextToken.substring(0, index);

					if (ExpressionHelper.isValidNumber(coeff) && ExpressionHelper.isValidVariable(var)) {
						if (varList.containsKey(var)) {
							if (this.op.equals("+")) {
								varList.put(var, varList.get(var) + Float.parseFloat(coeff));
							} else if (this.op.equals("-")) {
								varList.put(var, varList.get(var) - Float.parseFloat(coeff));
							} else if (this.op.equals("&")) {

							} else if (this.op.equals("|")) {

							}
						} else {
							if (this.op.equals("+")) {
								varList.put(var, Float.parseFloat(coeff));
							} else if (this.op.equals("-")) {
								varList.put(var, 0 - Float.parseFloat(coeff));
							} else if (this.op.equals("&")) {

							} else if (this.op.equals("|")) {

							}
						}
						
					} else {
						if (varList.containsKey(nextToken)) {
							if (this.op.equals("+")) {
								varList.put(nextToken, varList.get(nextToken) + 1);
							} else if (this.op.equals("-")) {
								varList.put(nextToken, varList.get(nextToken) - 1);
							} else if (this.op.equals("&")) {

							} else if (this.op.equals("|")) {

							}
						} else {
							if (this.op.equals("+")) {
								varList.put(nextToken, (float) 1);
							} else if (this.op.equals("-")) {
								varList.put(nextToken, (float) -1);
							} else if (this.op.equals("&")) {

							} else if (this.op.equals("|")) {

							}
						}
					}
					
				} else if (nextToken.contains("/") && !nextToken.contains("%")) {
					int index = nextToken.indexOf("/");
					String var = nextToken.substring(index);
					String coeff = nextToken.substring(0, index);

					if (varList.containsKey(var)) {
						varListNumerator.get(var).append(op);
						varListNumerator.get(var).append(coeff);
					} else {
						varList.put(var, (float) 1);
						varListNumerator.put(var, new AddSubBit(coeff, false));
					}

				} else {
					
					if (varList.containsKey(nextToken)) {
						if (this.op.equals("+")) {
							varList.put(nextToken, varList.get(nextToken) + 1);
						} else if (this.op.equals("-")) {
							varList.put(nextToken, varList.get(nextToken) - 1);
						} else if (this.op.equals("&")) {

						} else if (this.op.equals("|")) {

						}
					} else {
						if (this.op.equals("+")) {
							varList.put(nextToken, (float) 1);
						} else if (this.op.equals("-")) {
							varList.put(nextToken, (float) -1);
						} else if (this.op.equals("&")) {

						} else if (this.op.equals("|")) {

						}
					}
				}
				prevTerm = Term.VAR;
			}
			break;

		case STRING:
			if (current == Term.STRING) {
				this.str = this.str.substring(0, this.str.length() - 1) + nextToken.substring(1);
				prevTerm = Term.STRING;
			} else if (current == null) {
				// do nothing
			} else {
				this.result += this.str + "+" + nextToken;
				this.str = "";
				prevTerm = Term.VAR;
			}
			break;

		case VAR:
			if (isStrOp) {
				this.str += nextToken;
				if (current == Term.STRING) {
					prevTerm = Term.STRING;
				} else {
					prevTerm = Term.VAR;
				}
			} else if (current == Term.NUMBER) {
				if (this.op.equals("+")) {
					this.val = this.val + Float.parseFloat(nextToken);
				} else if (this.op.equals("-")) {
					this.val = this.val - Float.parseFloat(nextToken);
				} else if (this.op.equals("&")) {

				} else if (this.op.equals("|")) {

				}
				prevTerm = Term.NUMBER;
			} else if (current == null) {
				// do nothing
			} else {
				if (nextToken.contains("*")) {
					int index = nextToken.indexOf("*");
					String var = nextToken.substring(index + 1);
					String coeff = nextToken.substring(0, index);

					if (ExpressionHelper.isValidNumber(coeff) && ExpressionHelper.isValidVariable(var)) {
						if (varList.containsKey(var)) {
							if (this.op.equals("+")) {
								varList.put(var, varList.get(var) + Float.parseFloat(coeff));
							} else if (this.op.equals("-")) {
								varList.put(var, varList.get(var) - Float.parseFloat(coeff));
							} else if (this.op.equals("&")) {

							} else if (this.op.equals("|")) {

							}
						} else {
							if (this.op.equals("+")) {
								varList.put(var, Float.parseFloat(coeff));
							} else if (this.op.equals("-")) {
								varList.put(var, 0 - Float.parseFloat(coeff));
							} else if (this.op.equals("&")) {

							} else if (this.op.equals("|")) {

							}
						}
					} else {
						if (varList.containsKey(nextToken)) {
							if (this.op.equals("+")) {
								varList.put(nextToken, varList.get(nextToken) + 1);
							} else if (this.op.equals("-")) {
								varList.put(nextToken, varList.get(nextToken) - 1);
							} else if (this.op.equals("&")) {

							} else if (this.op.equals("|")) {

							}
						} else {
							if (this.op.equals("+")) {
								varList.put(nextToken, (float) 1);
							} else if (this.op.equals("-")) {
								varList.put(nextToken, (float) -1);
							} else if (this.op.equals("&")) {

							} else if (this.op.equals("|")) {

							}
						}
					}
				} else if (nextToken.contains("/") && !nextToken.contains("%")) {
					int index = nextToken.indexOf("/");
					String var = nextToken.substring(index);
					String coeff = nextToken.substring(0, index);

					if (varList.containsKey(var)) {
						varListNumerator.get(var).append(op);
						varListNumerator.get(var).append(coeff);
					} else {
						varList.put(var, (float) 1);
						varListNumerator.put(var, new AddSubBit(coeff, false));
					}
				} else {
					if (varList.containsKey(nextToken)) {
						if (this.op.equals("+")) {
							varList.put(nextToken, varList.get(nextToken) + 1);
						} else if (this.op.equals("-")) {
							varList.put(nextToken, varList.get(nextToken) - 1);
						} else if (this.op.equals("&")) {

						} else if (this.op.equals("|")) {

						}
					} else {
						if (this.op.equals("+")) {
							varList.put(nextToken, (float) 1);
						} else if (this.op.equals("-")) {
							varList.put(nextToken, (float) -1);
						} else if (this.op.equals("&")) {

						} else if (this.op.equals("|")) {

						}
					}
				}
				prevTerm = Term.VAR;
			}
			break;

		default:
			break;

		}

	}

	private String evaluateVar() {
		Iterator<String> varKeys = varList.keySet().iterator();
		Iterator<Float> varVals = varList.values().iterator();
		StringBuilder sb = new StringBuilder();
		while (varKeys.hasNext()) {
			String key = varKeys.next();
			float val = varVals.next();
			if (val == 0) {
				// do nothing
			} else if (val == 1) {
				if (key.startsWith("/")) {
					String numerator = varListNumerator.get(key).evaluateFinal();
					if (ExpressionHelper.isValidNumber(numerator) || ExpressionHelper.isValidVariable(numerator)) {
						sb.append(numerator);
					} else {
						sb.append("("+ numerator + ")");
					}
					sb.append(key);
					sb.append("+");
				} else {
					sb.append(key);
					sb.append("+");
				}
			} else if (val == -1) {
				sb.append("-" + key);
				sb.append("+");
			} else {
				sb.append(val + "*" + key);
				sb.append("+");
			}
		}

		if (sb.length() == 0) {
			return "";
		}

		return sb.substring(0, sb.length() - 1).toString();
	}

	public String evaluateFinal() {
		if (isStrOp) {
			this.result += this.str;
			// System.out.println(this.result);
			return this.result;
		} else {
			String var = evaluateVar();
			this.result = this.val.toString();
			if (var.length() != 0) {
				if (val == 0) {
					this.result = var;
				} else if (var.startsWith("-")) {
					this.result = this.result + var;
				} else {
					this.result = this.result + "+" + var;
				}
			}
			//System.out.println(this.result);
			return this.result;
		}
	}

	public static void main(String[] args) {
		// "5+8*varName+varName+2";
		AddSubBit addSubBit = new AddSubBit("5", false);
		addSubBit.append("+");
		addSubBit.append("8*x*x");
		addSubBit.evaluateFinal();
	}
}
