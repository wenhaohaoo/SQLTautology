import java.util.HashMap;
import java.util.Iterator;

public class MultDivMod {

	private Float val = (float) 1.0;
	private String op;
	private String result;
	private HashMap<String, Integer> varList;
	private boolean prevIsVar = false;
	private boolean isNeg = false;
	
	public MultDivMod(String x, String op) {
		varList = new HashMap<String, Integer>();
		if (x.startsWith("-")) {
			isNeg = isNeg ^ x.startsWith("-");
			x = x.substring(1);
		}
		if (ExpressionHelper.isValidNumber(x)) {
			this.val = Float.parseFloat(x);
		} else if (ExpressionHelper.isValidVariable(x)) {
			varList.put(x, 1);
			prevIsVar = true;
		}
		this.op = op;
	}
	
	public void append(String nextToken) {
		nextToken = nextToken.trim();
		if (nextToken.startsWith("-")) {
			isNeg = isNeg ^ nextToken.startsWith("-");
			nextToken = nextToken.substring(1);
		}
		if (nextToken.matches("\\*|/|%")) {
			this.op = nextToken;
		} else if (ExpressionHelper.isValidNumber(nextToken)) {
			Float num = Float.parseFloat(nextToken);
			if (this.op.equals("*")) {
				if (this.val != null) { 
					this.val = this.val * num;
				} else {
					this.val = num;
				}
			} else if (this.op.equals("/")) {
				if (this.val != null) { 
					this.val = this.val / num;
				} else {
					this.val = num;
					
				}
			} else if (this.op.equals("%")) {
				if (prevIsVar) {
					String var = evaluateVar(num, true);
					varList = new HashMap<String, Integer>();
					varList.put(var, 1);
					
				} else {
					this.val = this.val % num;
				}
			}
			prevIsVar = false;
		} else if (ExpressionHelper.isValidVariable(nextToken)) {
			if (this.op.equals("*")) {
				if (varList.containsKey(nextToken)) {
					varList.put(nextToken, varList.get(nextToken)+1);
				} else {
					varList.put(nextToken, 1);
				}
			} else if (this.op.equals("/")) {
				if (varList.containsKey(nextToken)) {
					varList.put(nextToken, varList.get(nextToken)-1);
				} else {
					varList.put(nextToken, -1);
				}
			} else if (this.op.equals("%")) {
				String var = evaluateVar(nextToken, true);
				varList = new HashMap<String, Integer>();
				varList.put(var, 1);
			}
			prevIsVar = true;
 		}
	}
	
	private String evaluateVar(Object num, boolean forMod) {
		Iterator<String> varKeys = varList.keySet().iterator();
		Iterator<Integer> varVals = varList.values().iterator(); 
		StringBuilder sb = new StringBuilder();
		while(varKeys.hasNext()) {
			String key = varKeys.next();
			int val = varVals.next();
			if (val > 0) {
				for (int i = 0; i < val; i++) {
					sb.append("*");
					sb.append(key);
				}
			} else  if (val < 0){
				for (int i = 0; i > val; i--) {
					sb.append("/");
					sb.append(key);
				}
			} else {
				sb.append("");
			}
		}
		
		if (sb.length() == 0) {
			return "";
		}

		String var = sb.toString();
		
		if (forMod) {		
			var = this.val + var;
			var = "(" + var + op + num + ")";
			this.val = (float) 1.0;			
			return var;
		} else {
			return var;
		}
	}
	
	public String evaluateFinal() {
		String var = evaluateVar(null, false);
		if (this.val == 1) {
			if (var.equals("")) {
				this.result = "1.0";
			} else {
				if (var.startsWith("/")) {
					this.result = "1.0" + var;
				} else {
					this.result = var.substring(1);
				}
			}
		} else {
			if (var.equals("")) {
				this.result = this.val.toString();
			} else {
				this.result = this.val + var;
			}
		}
		
		if (isNeg) {
			this.result = "-" + this.result;
		}
		return this.result;
	}
	
	public static void main(String[] args) {
		MultDivMod multDivMod = new MultDivMod("3", "*");
		multDivMod.append("x");
		multDivMod.evaluateFinal();
	}
 	
}
