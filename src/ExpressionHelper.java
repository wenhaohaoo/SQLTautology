
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionHelper {

	private static HashSet<String> reserved;
	public static List<String> validComparatorList = Arrays.asList("=", ">", "<", ">=", "<=", "!=", "<>");

	public static void initializeReservedHashSet() {
		reserved = new HashSet<String>();
		reserved.add("ADD");
		reserved.add("EXTERNAL");
		reserved.add("PROCEDURE");
		reserved.add("ALL");
		reserved.add("FETCH");
		reserved.add("PUBLIC");
		reserved.add("ALTER");
		reserved.add("FILE");
		reserved.add("RAISERROR");
		reserved.add("AND");
		reserved.add("FILLFACTOR");
		reserved.add("READ");
		reserved.add("ANY");
		reserved.add("FOR");
		reserved.add("READTEXT");
		reserved.add("AS");
		reserved.add("FOREIGN");
		reserved.add("RECONFIGURE");
		reserved.add("ASC");
		reserved.add("FREETEXT");
		reserved.add("REFERENCES");
		reserved.add("AUTHORIZATION");
		reserved.add("FREETEXTTABLE");
		reserved.add("REPLICATION");
		reserved.add("BACKUP");
		reserved.add("FROM");
		reserved.add("RESTORE");
		reserved.add("BEGIN");
		reserved.add("FULL");
		reserved.add("RESTRICT");
		reserved.add("BETWEEN");
		reserved.add("FUNCTION");
		reserved.add("RETURN");
		reserved.add("BREAK");
		reserved.add("GOTO");
		reserved.add("REVERT");
		reserved.add("BROWSE");
		reserved.add("GRANT");
		reserved.add("REVOKE");
		reserved.add("BULK");
		reserved.add("GROUP");
		reserved.add("RIGHT");
		reserved.add("BY");
		reserved.add("HAVING");
		reserved.add("ROLLBACK");
		reserved.add("CASCADE");
		reserved.add("HOLDLOCK");
		reserved.add("ROWCOUNT");
		reserved.add("CASE");
		reserved.add("IDENTITY");
		reserved.add("ROWGUIDCOL");
		reserved.add("CHECK");
		reserved.add("IDENTITY_INSERT");
		reserved.add("RULE");
		reserved.add("CHECKPOINT");
		reserved.add("IDENTITYCOL");
		reserved.add("SAVE");
		reserved.add("CLOSE");
		reserved.add("IF");
		reserved.add("SCHEMA");
		reserved.add("CLUSTERED");
		reserved.add("IN");
		reserved.add("SECURITYAUDIT");
		reserved.add("COALESCE");
		reserved.add("INDEX");
		reserved.add("SELECT");
		reserved.add("COLLATE");
		reserved.add("INNER");
		reserved.add("SEMANTICKEYPHRASETABLE");
		reserved.add("COLUMN");
		reserved.add("INSERT");
		reserved.add("SEMANTICSIMILARITYDETAILSTABLE");
		reserved.add("COMMIT");
		reserved.add("INTERSECT");
		reserved.add("SEMANTICSIMILARITYTABLE");
		reserved.add("COMPUTE");
		reserved.add("INTO");
		reserved.add("SESSION_USER");
		reserved.add("CONSTRAINT");
		reserved.add("IS");
		reserved.add("SET");
		reserved.add("CONTAINS");
		reserved.add("JOIN");
		reserved.add("SETUSER");
		reserved.add("CONTAINSTABLE");
		reserved.add("KEY");
		reserved.add("SHUTDOWN");
		reserved.add("CONTINUE");
		reserved.add("KILL");
		reserved.add("SOME");
		reserved.add("CONVERT");
		reserved.add("LEFT");
		reserved.add("STATISTICS");
		reserved.add("CREATE");
		reserved.add("LIKE");
		reserved.add("SYSTEM_USER");
		reserved.add("CROSS");
		reserved.add("LINENO");
		reserved.add("TABLE");
		reserved.add("CURRENT");
		reserved.add("LOAD");
		reserved.add("TABLESAMPLE");
		reserved.add("CURRENT_DATE");
		reserved.add("MERGE");
		reserved.add("TEXTSIZE");
		reserved.add("CURRENT_TIME");
		reserved.add("NATIONAL");
		reserved.add("THEN");
		reserved.add("CURRENT_TIMESTAMP");
		reserved.add("NOCHECK");
		reserved.add("TO");
		reserved.add("CURRENT_USER");
		reserved.add("NONCLUSTERED");
		reserved.add("TOP");
		reserved.add("CURSOR");
		reserved.add("NOT");
		reserved.add("TRAN");
		reserved.add("DATABASE");
		reserved.add("NULL");
		reserved.add("TRANSACTION");
		reserved.add("DBCC");
		reserved.add("NULLIF");
		reserved.add("TRIGGER");
		reserved.add("DEALLOCATE");
		reserved.add("OF");
		reserved.add("TRUNCATE");
		reserved.add("DECLARE");
		reserved.add("OFF");
		reserved.add("TRY_CONVERT");
		reserved.add("DEFAULT");
		reserved.add("OFFSETS");
		reserved.add("TSEQUAL");
		reserved.add("DELETE");
		reserved.add("ON");
		reserved.add("UNION");
		reserved.add("DENY");
		reserved.add("OPEN");
		reserved.add("UNIQUE");
		reserved.add("DESC");
		reserved.add("OPENDATASOURCE");
		reserved.add("UNPIVOT");
		reserved.add("DISK");
		reserved.add("OPENQUERY");
		reserved.add("UPDATE");
		reserved.add("DISTINCT");
		reserved.add("OPENROWSET");
		reserved.add("UPDATETEXT");
		reserved.add("DISTRIBUTED");
		reserved.add("OPENXML");
		reserved.add("USE");
		reserved.add("DOUBLE");
		reserved.add("OPTION");
		reserved.add("USER");
		reserved.add("DROP");
		reserved.add("OR");
		reserved.add("VALUES");
		reserved.add("DUMP");
		reserved.add("ORDER");
		reserved.add("VARYING");
		reserved.add("ELSE");
		reserved.add("OUTER");
		reserved.add("VIEW");
		reserved.add("END");
		reserved.add("OVER");
		reserved.add("WAITFOR");
		reserved.add("ERRLVL");
		reserved.add("PERCENT");
		reserved.add("WHEN");
		reserved.add("ESCAPE");
		reserved.add("PIVOT");
		reserved.add("WHERE");
		reserved.add("EXCEPT");
		reserved.add("PLAN");
		reserved.add("WHILE");
		reserved.add("EXEC");
		reserved.add("PRECISION");
		reserved.add("WITH");
		reserved.add("EXECUTE");
		reserved.add("PRIMARY");
		reserved.add("WITHIN");
		reserved.add("GROUP");
		reserved.add("EXISTS");
		reserved.add("PRINT");
		reserved.add("WRITETEXT");
		reserved.add("EXIT");
		reserved.add("PROC");
		reserved.add("ABSOLUTE");
		reserved.add("HOST");
		reserved.add("RELATIVE");
		reserved.add("ACTION");
		reserved.add("HOUR");
		reserved.add("RELEASE");
		reserved.add("ADMIN");
		reserved.add("IGNORE");
		reserved.add("RESULT");
		reserved.add("AFTER");
		reserved.add("IMMEDIATE");
		reserved.add("RETURNS");
		reserved.add("AGGREGATE");
		reserved.add("INDICATOR");
		reserved.add("ROLE");
		reserved.add("ALIAS");
		reserved.add("INITIALIZE");
		reserved.add("ROLLUP");
		reserved.add("ALLOCATE");
		reserved.add("INITIALLY");
		reserved.add("ROUTINE");
		reserved.add("ARE");
		reserved.add("INOUT");
		reserved.add("ROW");
		reserved.add("ARRAY");
		reserved.add("INPUT");
		reserved.add("ROWS");
		reserved.add("ASENSITIVE");
		reserved.add("INT");
		reserved.add("SAVEPOINT");
		reserved.add("ASSERTION");
		reserved.add("INTEGER");
		reserved.add("SCROLL");
		reserved.add("ASYMMETRIC");
		reserved.add("INTERSECTION");
		reserved.add("SCOPE");
		reserved.add("AT");
		reserved.add("INTERVAL");
		reserved.add("SEARCH");
		reserved.add("ATOMIC");
		reserved.add("ISOLATION");
		reserved.add("SECOND");
		reserved.add("BEFORE");
		reserved.add("ITERATE");
		reserved.add("SECTION");
		reserved.add("BINARY");
		reserved.add("LANGUAGE");
		reserved.add("SENSITIVE");
		reserved.add("BIT");
		reserved.add("LARGE");
		reserved.add("SEQUENCE");
		reserved.add("BLOB");
		reserved.add("LAST");
		reserved.add("SESSION");
		reserved.add("BOOLEAN");
		reserved.add("LATERAL");
		reserved.add("SETS");
		reserved.add("BOTH");
		reserved.add("LEADING");
		reserved.add("SIMILAR");
		reserved.add("BREADTH");
		reserved.add("LESS");
		reserved.add("SIZE");
		reserved.add("CALL");
		reserved.add("LEVEL");
		reserved.add("SMALLINT");
		reserved.add("CALLED");
		reserved.add("LIKE_REGEX");
		reserved.add("SPACE");
		reserved.add("CARDINALITY");
		reserved.add("LIMIT");
		reserved.add("SPECIFIC");
		reserved.add("CASCADED");
		reserved.add("LN");
		reserved.add("SPECIFICTYPE");
		reserved.add("CAST");
		reserved.add("LOCAL");
		reserved.add("SQL");
		reserved.add("CATALOG");
		reserved.add("LOCALTIME");
		reserved.add("SQLEXCEPTION");
		reserved.add("CHAR");
		reserved.add("LOCALTIMESTAMP");
		reserved.add("SQLSTATE");
		reserved.add("CHARACTER");
		reserved.add("LOCATOR");
		reserved.add("SQLWARNING");
		reserved.add("CLASS");
		reserved.add("MAP");
		reserved.add("START");
		reserved.add("CLOB");
		reserved.add("MATCH");
		reserved.add("STATE");
		reserved.add("COLLATION");
		reserved.add("MEMBER");
		reserved.add("STATEMENT");
		reserved.add("COLLECT");
		reserved.add("METHOD");
		reserved.add("STATIC");
		reserved.add("COMPLETION");
		reserved.add("MINUTE");
		reserved.add("STDDEV_POP");
		reserved.add("CONDITION");
		reserved.add("MOD");
		reserved.add("STDDEV_SAMP");
		reserved.add("CONNECT");
		reserved.add("MODIFIES");
		reserved.add("STRUCTURE");
		reserved.add("CONNECTION");
		reserved.add("MODIFY");
		reserved.add("SUBMULTISET");
		reserved.add("CONSTRAINTS");
		reserved.add("MODULE");
		reserved.add("SUBSTRING_REGEX");
		reserved.add("CONSTRUCTOR");
		reserved.add("MONTH");
		reserved.add("SYMMETRIC");
		reserved.add("CORR");
		reserved.add("MULTISET");
		reserved.add("SYSTEM");
		reserved.add("CORRESPONDING");
		reserved.add("NAMES");
		reserved.add("TEMPORARY");
		reserved.add("COVAR_POP");
		reserved.add("NATURAL");
		reserved.add("TERMINATE");
		reserved.add("COVAR_SAMP");
		reserved.add("NCHAR");
		reserved.add("THAN");
		reserved.add("CUBE");
		reserved.add("NCLOB");
		reserved.add("TIME");
		reserved.add("CUME_DIST");
		reserved.add("NEW");
		reserved.add("TIMESTAMP");
		reserved.add("CURRENT_CATALOG");
		reserved.add("NEXT");
		reserved.add("TIMEZONE_HOUR");
		reserved.add("CURRENT_DEFAULT_TRANSFORM_GROUP");
		reserved.add("NO");
		reserved.add("TIMEZONE_MINUTE");
		reserved.add("CURRENT_PATH");
		reserved.add("NONE");
		reserved.add("TRAILING");
		reserved.add("CURRENT_ROLE");
		reserved.add("NORMALIZE");
		reserved.add("TRANSLATE_REGEX");
		reserved.add("CURRENT_SCHEMA");
		reserved.add("NUMERIC");
		reserved.add("TRANSLATION");
		reserved.add("CURRENT_TRANSFORM_GROUP_FOR_TYPE");
		reserved.add("OBJECT");
		reserved.add("TREAT");
		reserved.add("CYCLE");
		reserved.add("OCCURRENCES_REGEX");
		reserved.add("TRUE");
		reserved.add("DATA");
		reserved.add("OLD");
		reserved.add("UESCAPE");
		reserved.add("DATE");
		reserved.add("ONLY");
		reserved.add("UNDER");
		reserved.add("DAY");
		reserved.add("OPERATION");
		reserved.add("UNKNOWN");
		reserved.add("DEC");
		reserved.add("ORDINALITY");
		reserved.add("UNNEST");
		reserved.add("DECIMAL");
		reserved.add("OUT");
		reserved.add("USAGE");
		reserved.add("DEFERRABLE");
		reserved.add("OVERLAY");
		reserved.add("USING");
		reserved.add("DEFERRED");
		reserved.add("OUTPUT");
		reserved.add("VALUE");
		reserved.add("DEPTH");
		reserved.add("PAD");
		reserved.add("VAR_POP");
		reserved.add("DEREF");
		reserved.add("PARAMETER");
		reserved.add("VAR_SAMP");
		reserved.add("DESCRIBE");
		reserved.add("PARAMETERS");
		reserved.add("VARCHAR");
		reserved.add("DESCRIPTOR");
		reserved.add("PARTIAL");
		reserved.add("VARIABLE");
		reserved.add("DESTROY");
		reserved.add("PARTITION");
		reserved.add("WHENEVER");
		reserved.add("DESTRUCTOR");
		reserved.add("PATH");
		reserved.add("WIDTH_BUCKET");
		reserved.add("DETERMINISTIC");
		reserved.add("POSTFIX");
		reserved.add("WITHOUT");
		reserved.add("DICTIONARY");
		reserved.add("PREFIX");
		reserved.add("WINDOW");
		reserved.add("DIAGNOSTICS");
		reserved.add("PREORDER");
		reserved.add("WITHIN");
		reserved.add("DISCONNECT");
		reserved.add("PREPARE");
		reserved.add("WORK");
		reserved.add("DOMAIN");
		reserved.add("PERCENT_RANK");
		reserved.add("WRITE");
		reserved.add("DYNAMIC");
		reserved.add("PERCENTILE_CONT");
		reserved.add("XMLAGG");
		reserved.add("EACH");
		reserved.add("PERCENTILE_DISC");
		reserved.add("XMLATTRIBUTES");
		reserved.add("ELEMENT");
		reserved.add("POSITION_REGEX");
		reserved.add("XMLBINARY");
		reserved.add("END-EXEC");
		reserved.add("PRESERVE");
		reserved.add("XMLCAST");
		reserved.add("EQUALS");
		reserved.add("PRIOR");
		reserved.add("XMLCOMMENT");
		reserved.add("EVERY");
		reserved.add("PRIVILEGES");
		reserved.add("XMLCONCAT");
		reserved.add("EXCEPTION");
		reserved.add("RANGE");
		reserved.add("XMLDOCUMENT");
		reserved.add("FALSE");
		reserved.add("READS");
		reserved.add("XMLELEMENT");
		reserved.add("FILTER");
		reserved.add("REAL");
		reserved.add("XMLEXISTS");
		reserved.add("FIRST");
		reserved.add("RECURSIVE");
		reserved.add("XMLFOREST");
		reserved.add("FLOAT");
		reserved.add("REF");
		reserved.add("XMLITERATE");
		reserved.add("FOUND");
		reserved.add("REFERENCING");
		reserved.add("XMLNAMESPACES");
		reserved.add("FREE");
		reserved.add("REGR_AVGX");
		reserved.add("XMLPARSE");
		reserved.add("FULLTEXTTABLE");
		reserved.add("REGR_AVGY");
		reserved.add("XMLPI");
		reserved.add("FUSION");
		reserved.add("REGR_COUNT");
		reserved.add("XMLQUERY");
		reserved.add("GENERAL");
		reserved.add("REGR_INTERCEPT");
		reserved.add("XMLSERIALIZE");
		reserved.add("GET");
		reserved.add("REGR_R2");
		reserved.add("XMLTABLE");
		reserved.add("GLOBAL");
		reserved.add("REGR_SLOPE");
		reserved.add("XMLTEXT");
		reserved.add("GO");
		reserved.add("REGR_SXX");
		reserved.add("XMLVALIDATE");
		reserved.add("GROUPING");
		reserved.add("REGR_SXY");
		reserved.add("YEAR");
		reserved.add("HOLD");
		reserved.add("REGR_SYY");
		reserved.add("ZONE");
	}

	public static boolean isValidNumber(String numberExpression) {
		return numberExpression.trim().matches("-?\\d+(\\.\\d+)?");
	}

	public static boolean isValidOperator(String operator) {
		return operator.matches("-|\\+|\\*|/|%|&|\\|");
	}

	public static boolean isValidVariable(String variableExpression) {
		StringTokenizer tokenizer = new StringTokenizer(variableExpression, ".");
		initializeReservedHashSet();

		if (tokenizer.countTokens() == 0) {
			return false;
		} else {

			while (tokenizer.hasMoreTokens()) {
				String token = tokenizer.nextToken();
				String trimmedToken = token.trim();

				if (trimmedToken.startsWith("[") && trimmedToken.endsWith("]")) {

					if (trimmedToken.substring(1, trimmedToken.length() - 1).startsWith(" ")
							|| trimmedToken.substring(1, trimmedToken.length() - 1).endsWith(" ")) {
						System.out.println(5);
						return false;
					} else if (Character.isDigit(trimmedToken.substring(1, trimmedToken.length() - 1).charAt(0))) {
						System.out.println(7);
						return false;
					}

				} else {

					if (!trimmedToken.matches("^[a-zA-Z][_$a-zA-Z0-9]*+")) {
						// System.out.println(1);
						return false;
					} else if (trimmedToken.startsWith("[") && !trimmedToken.endsWith("]")) {
						System.out.println(2);
						return false;
					} else if (!trimmedToken.startsWith("[") && trimmedToken.endsWith("]")) {
						System.out.println(3);
						return false;
					} else if (trimmedToken.contains(" ")) {
						System.out.println(4);
						return false;
					} else if (Character.isDigit(trimmedToken.charAt(0))) {
						System.out.println(6);
						return false;
					} else if (reserved.contains(trimmedToken.toUpperCase())) {
						System.out.println(8);
						return false;
					}

				}
			}
			return true;
		}
	}

	public static boolean isValidString(String stringExpression) {
		if (stringExpression.matches("^\'.*\'$")) {
			// String subStringExpression =
			// stringExpression.substring(1,stringExpression.length()-1);
			// System.out.println(subStringExpression);
			return !stringExpression.matches(".*(\'\\p{Space}+\').*");
		}
		return false;
	}

	public static boolean isValidNull(String nullExpression) {
		return nullExpression.equalsIgnoreCase("NULL");
	}

	public static boolean isValidComparator(String comparatorExpression) {
		return validComparatorList.contains(comparatorExpression);
	}

	public static String[] parseSingle(String expression, boolean seprateBrackets) {

		if (!seprateBrackets) {
			StringTokenizer tokenizer = new StringTokenizer(expression, ")-+*/%&|(", true);
			ArrayList<String> result = new ArrayList<String>();
			StringBuilder sb = new StringBuilder();
			boolean appending = false;
			boolean isOp = false;
			boolean isNeg = false;
			int brackets = 0;

			while (tokenizer.hasMoreTokens()) {
				String token;
				if (isNeg) {
					token = "-" + tokenizer.nextToken().trim();
					isNeg = false;
				} else {
					token = tokenizer.nextToken().trim();
				}

				if (token.trim().equals("(")) {
					sb.append(token);
					brackets++;
					appending = true;
				} else if (token.trim().equals(")")) {
					sb.append(token);
					brackets--;
					if (brackets == 0) {
						appending = false;
						result.add(sb.toString());
						sb = new StringBuilder();
					}
				} else if (!token.equals(" ")) {
					if (appending) {
						sb.append(token);
					} else {
						if (token.equals("-") && isOp) {
							isOp = false;
							isNeg = true;
						} else if (token.matches("-|\\+|\\*|/|%|&|\\|")) {
							isOp = true;
							result.add(token);
						} else {
							isOp = false;
							result.add(token);
						}
					}
				}
			}
			return result.toArray(new String[result.size()]);
		} else {

			StringTokenizer tokenizer = new StringTokenizer(expression, ")-+*/%&|(,", true);
			ArrayList<String> result = new ArrayList<String>();
			StringBuilder sb = new StringBuilder();
			while (tokenizer.hasMoreTokens()) {
				String token = tokenizer.nextToken().trim();
				result.add(token);
			}
			return result.toArray(new String[result.size()]);
		}
	}

	public static String standardize(String basicExpression) {
		StringTokenizer tokenizer = new StringTokenizer(basicExpression, ")-+*/%(.", true);
		StringBuilder sb = new StringBuilder();
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken().trim();
			if (isValidVariable(token)) {
				if (!(token.startsWith("[") && token.endsWith("]"))) {
					token = "[" + token + "]";
				}
				token = token.toUpperCase();
			}
			sb.append(token);
		}
		return sb.toString();
	}

	public static boolean isValidExpression(String expression) {

		/* Indicator Variables */
		boolean hasNumber = false;
		boolean hasString = false;
		boolean hasVariable = false;
		boolean hasNull = false;
		Boolean hasOtherOp = null;
		boolean isOp = false;
		boolean isOpBrac = false;
		boolean hasConsecutiveOps = false;
		int brackets = 0;
		String op = "";

		String[] components = parseSingle(expression, true);
		if (components.length == 0) {
			return false;
		} else if (!(components[0].equals("-") || components[0].equals("(") || components[0].equals("")
				|| isValidNumber(components[0]) || isValidVariable(components[0]) || isValidString(components[0])
				|| isValidNull(components[0]))) {
			System.out.println("cannot start with: " + components[0]);
			return false;
		}

		for (int i = 0; i < components.length; i++) {

			if (isValidNumber(components[i])) {
				hasNumber = true;
				isOp = false;
				isOpBrac = false;
			} else if (isValidString(components[i])) {
				hasString = true;
				isOp = false;
				isOpBrac = false;
			} else if (isValidVariable(components[i])) {
				hasVariable = true;
				isOp = false;
				isOpBrac = false;
			} else if (isValidNull(components[i])) {
				hasNull = true;
				isOp = false;
				isOpBrac = false;
			} else if (components[i].matches("-|\\+|\\*|/|%|&|\\|")) {

				if (isOpBrac) {
					System.err.println("opening bracket should not be followed by op");
					return false;
				}

				if (isOp) {
					hasConsecutiveOps = true;
					op = op + components[i];
				} else {
					isOp = true;
					op = components[i];
				}

				if (components[i].matches("-||\\*|/|%|&|\\|")) {
					hasOtherOp = true;
				}

				isOpBrac = false;

			} else if (components[i].matches("\\(")) {
				brackets++;
				isOpBrac = true;
				isOp = false;
			} else if (components[i].matches("\\)")) {
				brackets--;
				if (brackets < 0 || isOp) {
					System.err.println(") cannot follow after op");
					return false;
				}
				isOp = false;
				isOpBrac = false;
			} else {
				System.err.println("got this case: " + components[i]);
				return false;
			}
		}

		if (hasNumber && hasString) {
			System.err.println("num & string");
			return false;
		} else if (hasNull && (hasString || hasVariable || hasNumber)) {
			System.err.println("null & smth else");
			return false;
		} else if (hasString && hasVariable) {
			System.err.println("string only +");
			if (hasOtherOp == null) {
				System.err.println("no op");
				return false;
			} else {
				return !hasOtherOp;
			}
		} else if (hasConsecutiveOps) {
			System.err.println("consecutive only +- or *- or /-");
			System.err.println(op);
			return op.equals("+-") || op.equals("*-") || op.equals("/-");
		} else if (brackets != 0) {
			System.err.println("opening and closing brackets not same");
			return false;
		} else if (components[0].matches("-|\\+|\\*|/|%|&|\\|")
				|| components[components.length - 1].matches("-|\\+|\\*|/|%|&|\\|")) {
			System.err.println("cannot start or end with op");
			return false;
		} else {
			return true;
		}
	}

	public static String simplify(String basicExpession) {
		basicExpession = standardize(basicExpession);
		String[] components = parseSingle(basicExpession, false);
		ArrayList<String> altered = new ArrayList<String>();
		boolean hasString = false;

		for (int i = 0; i < components.length; i++) {
			if (components[i].matches("\\*|/|%") && !isValidString(components[i])) {
				altered.remove(altered.size() - 1);
				StringBuilder sb = new StringBuilder();
				MultDivMod mdm = new MultDivMod(components[i - 1], components[i]);
				sb.append(components[i - 1]);
				sb.append(components[i]);

				if (i + 2 >= components.length) {
					mdm.append(components[i + 1]);
					i++;
				} else {
					while (components[i + 2].matches("\\*|/|%")) {
						mdm.append(components[i + 1]);
						mdm.append(components[i + 2]);
						i += 2;

						if (i + 2 >= components.length) {
							mdm.append(components[i + 1]);
							i++;
							break;
						}
					}
					if (i + 2 < components.length) {
						mdm.append(components[i + 1]);
						i++;
					}
				}
				altered.add(mdm.evaluateFinal());
			} else {
				altered.add(components[i]);
				if (isValidString(components[i])) {
					hasString = true;
				}
			}
		}

		AddSubBit addSubBit = new AddSubBit(altered.get(0), hasString);
		for (int i = 1; i < altered.size(); i++) {
			addSubBit.append(altered.get(i));
		}
		return addSubBit.evaluateFinal();

	}

	public static String[] evaluate(String expression) {
		String[] components = parseSingle(expression, false);
		boolean hasString = false;

		for (int i = 0; i < components.length; i++) {
			if (isValidString(components[i])) {
				hasString = true;
			}
		}

		if (hasString) {
			AddSubBit addSubBit = new AddSubBit(components[0], hasString);
			for (int i = 1; i < components.length; i++) {
				addSubBit.append(components[i]);
			}
			String[] result = new String[0];
			result[0] = addSubBit.evaluateFinal();
			return result;
		} else {
			return SympySolver.solve(expression);
		}

	}

	public static ExpressionDescription parse(String fullExpression) {
		Pattern pattern = Pattern.compile("(?<comparator><>|[<>!]=?|[=!]>?|[=!>]<?|[<>=]!?)");
		// Pattern pattern =
		// Pattern.compile("(?<comparator><>|<=|>=|!=|>|<|=)");
		Matcher matcher = pattern.matcher(fullExpression);
		ExpressionDescription obj = new ExpressionDescription(fullExpression);
		if (matcher.find() && isValidComparator(matcher.group("comparator"))) {
			// System.out.println("Success: " + matcher.group(1));
			String comparator = matcher.group("comparator");
			if (matcher.find()) {
				obj.setSuccessful(false);
				return obj;
			} else {
				obj.setLeftExpression(fullExpression.substring(0, fullExpression.indexOf(comparator.charAt(0))));
				obj.setComparatorString(comparator);
				obj.setRightExpression(fullExpression
						.substring(fullExpression.indexOf(comparator.charAt(comparator.length() - 1)) + 1));
				return obj;
			}
		} else {
			obj = new ExpressionDescription(fullExpression);
			obj.setSuccessful(false);
			return obj;
		}
	}

	public static boolean isTautology(String fullExpression) {

		ExpressionDescription expDes = parse(fullExpression);
		Boolean isEqual = null;
		Boolean isGreater = null;
		Boolean isLesser = null;

		if (expDes.isSuccessful()) {

			String left = expDes.getLeftExpression();
			String right = expDes.getRightExpression();

			if (isValidExpression(left) && isValidExpression(right)) {

				boolean hasNumber = false;
				boolean hasString = false;
				boolean hasVariable = false;
				boolean hasNull = false;
				boolean moreThanOneVar = false;
				String var = "";

				fullExpression = expDes.getLeftExpression() + "- (" + expDes.getRightExpression() + ")";
				String[] components = parseSingle(fullExpression, true);

				for (int i = 0; i < components.length; i++) {
					if (isValidNumber(components[i])) {
						hasNumber = true;
					} else if (isValidString(components[i])) {
						hasString = true;
					} else if (isValidVariable(components[i])) {
						hasVariable = true;
						if (!var.equals("") && !var.equals(components[i])) {
							moreThanOneVar = true;
						} else {
							var = components[i];
						}
					} else if (isValidNull(components[i])) {
						hasNull = true;
					}
				}

				if (hasString) {

					/* don't know what to do with Strings yet */

				} else if (hasVariable) {
			        
					if (moreThanOneVar) {
						System.err.println("unable to solve for more than 1 var");
						return false;
					} else {
						String[] result = evaluate(fullExpression);
						if (result[1] == null) {
							// no roots
							float ans = subIn(fullExpression, var, "1");
							if (ans > 0) {
								isEqual = false;
								isGreater = true;
								isLesser = false;
							} else if (ans < 0) {
								isEqual = false;
								isGreater = false;
								isLesser = true;
							} else {
								isEqual = true;
								isGreater = false;
								isLesser = false;
							}
						} else {
							String roots = result[1];

							if (roots.contains("*I*")) {
								System.err.println("no real roots, imaginary");
								return false;
							} else {
								StringTokenizer tokenizer = new StringTokenizer(roots, ",");
								ArrayList<Float> floatRoots = new ArrayList<Float>();
								ArrayList<Float> yValList = new ArrayList<Float>();
								while (tokenizer.hasMoreTokens()) {
									String token = tokenizer.nextToken().trim();
									token = token.substring(0, token.indexOf(":")).replace("{", "").replace("}", "");
									floatRoots.add(Float.parseFloat(token));
								}

								for (int i = 0; i < floatRoots.size(); i++) {
									float yVal = subIn(result[2], var, floatRoots.get(i).toString());
									yValList.add(yVal);
								}

								float max = Collections.max(yValList);
								float min = Collections.min(yValList);

								if (yValList.contains(0)) {
									isEqual = true;
								} else {
									isEqual = false;
								}

								if (max >= 0 && min >= 0) {
									isGreater = true;
									isLesser = false;
								} else if (max <= 0 && min <= 0) {
									isGreater = false;
									isLesser = true;
								} else {
									System.err.println("graph cuts the x-axis, not tautology");
									return false;
								}

							}
						}
					}

				} else {
					float result = Float.parseFloat(evaluate(fullExpression)[0]);
					if (result == 0) {
						isEqual = true;
						isGreater = false;
						isLesser = false;
					} else if (result > 0) {
						isEqual = false;
						isGreater = true;
						isLesser = false;
					} else if (result < 0) {
						isEqual = false;
						isGreater = false;
						isLesser = true;
					}
				}

				switch (expDes.getComparatorString()) {

				case "=":
					return isEqual && !isGreater && !isLesser;

				case "!=":
				case "<>":
					return !(isEqual && !isGreater && !isLesser);

				case ">":
					return isGreater && !isEqual;

				case "<":
					return isLesser && !isEqual;

				case "<=":
					return isEqual || isLesser;

				case ">=":
					return isEqual || isGreater;

				default:
					System.err.println(
							String.format("comparator %s not recognised, bug detected", expDes.getComparatorString()));
					return false;
				}

			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	private static float subIn(String eqn, String var, String val) {
		eqn = eqn.replaceAll(var, val);
		return Float.parseFloat(SympySolver.solve(eqn)[0]);

	}

	public static void main(String[] args) {
		// System.out.println(standardize("1.2 * varName
		// .hasSpaceBeforeAndAfterDot . [already has bracket] * -88 + 'hello!
		// Leave the spaces and CaPiTaLiSaTiOn alone!'"));
		// System.out.println(evaluate("5+8*3"));
		// System.out.println(evaluate("5+8*varName+varName+2"));
		// System.out.println(evaluate("5+8*varName*varName-7"));
		// System.out.println(evaluate("5+8*varName*varName/varName-5*varName+0-0"));
		// System.out.println(evaluate("5+8*varName*varName/varName/varName"));
		// System.out.println(evaluate("5+8*varName*varName/varName/varName/varName"));
		// System.out.println(evaluate("'he'+'llo'+varName"));
		// System.out.println(evaluate("'he'+varName+'llo'"));
		// System.out.println(evaluate("'he'+''+'llo'"));
		// System.out.println(evaluate("1/x+2/x+2/y+4/y+3*x%3-5*x/y+x/y+7*x/y+6/y"));
		// System.out.println(evaluate("3*x%3"));
		// System.out.println(evaluate("4*(5*xs+2)"));
		// System.out.println(parseSingle("1++1", false));
		// System.out.println(evaluate("3/y+x/y"));
		// System.out.println(evaluate("'asd'+'asd'+zxc+'zxc'"));
		// System.out.println(evaluate("x*(uuuuu%4+3+4*(3+s)*4/3)+2"));

		System.out.println(isTautology("x/x>0"));
		// String[] a = parseSingle("5+4-(3*[x.y]+-2)/1");
		// for (int i = 0; i < a.length; i++) {
		// System.out.println(a[i]);
		// }
		String[] asd = new String[2];
		asd[0] = "a";
	}
}
