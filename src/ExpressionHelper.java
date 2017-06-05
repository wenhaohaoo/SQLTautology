
import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

import javax.lang.model.element.VariableElement;
import javax.security.auth.SubjectDomainCombiner;
import javax.xml.stream.events.StartDocument;

import javafx.beans.property.StringProperty;

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

	public static String[] parseSingle(String expression) {

//		StringTokenizer tokenizer = new StringTokenizer(expression, ")-+*/%&|(", true);
//		ArrayList<String> result = new ArrayList<String>();
//		StringBuilder sb = new StringBuilder();
//		boolean appending = false;
//		boolean isOp = false;
//		boolean isNeg = false;
//		int brackets = 0;
//
//		while (tokenizer.hasMoreTokens()) {
//			String token;
//			if (isNeg) {
//				token = "-" + tokenizer.nextToken().trim();
//				isNeg = false;
//			} else {
//				token = tokenizer.nextToken().trim();
//			}
//
//			if (token.trim().equals("(")) {
//				sb.append(token);
//				brackets++;
//				appending = true;
//			} else if (token.trim().equals(")")) {
//				sb.append(token);
//				brackets--;
//				if (brackets == 0) {
//					appending = false;
//					result.add(sb.toString());
//					sb = new StringBuilder();
//				}
//			} else if (!token.equals(" ")) {
//				if (appending) {
//					sb.append(token);
//				} else {
//					if (token.equals("-") && isOp) {
//						isOp = false;
//						isNeg = true;
//					} else if (token.matches("-|\\+|\\*|/|%|&|\\|")) {
//						isOp = true;
//						result.add(token);
//					} else {
//						isOp = false;
//						result.add(token);
//					}
//				}
//			}
//		}
//		return result.toArray(new String[result.size()]);
		
		StringTokenizer tokenizer = new StringTokenizer(expression, ")-+*/%&|(", true);
		ArrayList<String> result = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();

		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken().trim();
			result.add(token);
		}
		return result.toArray(new String[result.size()]);
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

	public static boolean isValidBasicExpression(String basicExpression) {

		/* Indicator Variables */
		boolean hasNumber = false;
		boolean hasString = false;
		boolean hasVariable = false;
		boolean hasNull = false;
		boolean hasOtherOp = false;
		boolean hasBrackets = false;
		boolean isOp = false;
		boolean hasConsecutiveOps = false;
		String op1 = "";
		String op2 = "";

		String[] components = parseSingle(basicExpression);

		for (int i = 0; i < components.length; i++) {
			if (isValidNumber(components[i])) {
				hasNumber = true;
			} else if (isValidString(components[i])) {
				hasString = true;
			} else if (isValidVariable(components[i])) {
				hasVariable = true;
			} else if (isValidNull(components[i])) {
				hasNull = true;
			} else if (components[i].matches("-|\\+|\\*|/|%|&|\\|")) {

				if (isOp) {
					hasConsecutiveOps = true;
					op2 = op1 + components[i];
				} else {
					isOp = true;
					op1 = components[i];
				}

				if (components[i].matches("-||\\*|/|%|&|\\|")) {
					hasOtherOp = true;
				}

			} else {
				isOp = false;
			}
		}

		if (hasNumber && hasString) {
			System.out.println("num & string");
			return false;
		} else if (hasNull && (hasString || hasVariable || hasNumber)) {
			System.out.println("null & smth else");
			return false;
		} else if (hasString) {
			System.out.println("string only +");
			return !hasOtherOp;
		} else if (hasConsecutiveOps) {
			System.out.println("consecutive only +-");
			return op2.equals("+-");
		} else {
			return true;
		}
	}

	public static String simplify(String basicExpession) {
		basicExpession = standardize(basicExpession);
		String[] components = parseSingle(basicExpession);
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

	public static String evaluate(String expression) {
		String[] components = parseSingle(expression);
		ArrayList<String> simplified = new ArrayList<String>();
		boolean hasString = false;

		// for (int i = 0; i < components.length; i ++) {
		// System.out.println(components[i]);
		// }

		for (int i = 0; i < components.length; i++) {
			String s = components[i];
			if (s.startsWith("(") && s.endsWith(")")) {
				String removedBrackets = s.substring(1, s.length() - 1);
				if (removedBrackets.contains("(") && removedBrackets.contains(")")) {
					removedBrackets = evaluate(removedBrackets);
				}
				removedBrackets = simplify(removedBrackets);

				// in cases where components[i] is the first term and i is 0;
				if (i != 0) {
					if (components[i - 1].equals("*") || components[i - 1].equals("/")) {
						removedBrackets = "{" + removedBrackets + "}";
					}
				}

				if (!removedBrackets.contains("{")
						&& (components[i + 1].equals("*") || components[i + 1].equals("/"))) {
					removedBrackets = "{" + removedBrackets + "}";
				}

				simplified.add(removedBrackets);

			} else {
				simplified.add(components[i]);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < simplified.size(); i++) {
			sb.append(simplified.get(i));
		}

		return simplify(sb.toString());
	}

	public static ExpressionDescription Parse(String fullExpression) {
		return null;
	}

	public static boolean isTautology(String fullExpression) {
		return true;
	}

	public static String solveBracket(String a, String b, String op) {

		ArrayList<String> aTokens = new ArrayList<String>();
		ArrayList<String> bTokens = new ArrayList<String>();
		ArrayList<String> result = new ArrayList<String>();
		boolean isANeg = false;
		boolean isBNeg = false;

		if (a.startsWith("{") && a.endsWith("}")) {
			String[] aComponents = parseSingle(a.substring(1, a.length() - 1));
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < aComponents.length; i++) {
				if (aComponents[i].matches("\\+|-") && i != 0) {
					aTokens.add(sb.toString());
					aTokens.add(aComponents[i]);
					sb = new StringBuilder();
				} else {
					sb.append(aComponents[i]);
				}
			}

			if (sb.length() != 0) {
				aTokens.add(sb.toString());
			}

		} else {
			aTokens.add(a);
		}

		if (b.startsWith("{") && b.endsWith("}")) {

			String[] bComponents = parseSingle(b.substring(1, b.length() - 1));
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bComponents.length; i++) {
				if (bComponents[i].matches("\\+|-") && i != 0) {
					bTokens.add(sb.toString());
					bTokens.add(bComponents[i]);
					sb = new StringBuilder();
				} else {
					sb.append(bComponents[i]);
				}
			}

			if (sb.length() != 0) {
				bTokens.add(sb.toString());
			}

		} else {
			bTokens.add(b);
		}

		AddSubBit addSubBit = new AddSubBit("0", false);
		for (int i = 0; i < aTokens.size(); i++) {
			String aToken = aTokens.get(i);
			if (aToken.equals("+")) {
				continue;
			} else if (aToken.equals("-")) {
				isANeg = isANeg ^ true;
				continue;
			} else if (aToken.startsWith("-")) {
				isANeg = true;
				aToken = aToken.substring(1);
			}

			for (int j = 0; j < bTokens.size(); j++) {
				String bToken = bTokens.get(j);
				if (bToken.equals("+")) {
					continue;
				} else if (bToken.equals("-")) {
					isBNeg = isBNeg ^ true;
					continue;
				} else if (bToken.startsWith("-")) {
					isBNeg = true;
					bToken = bToken.substring(1);
				}

				boolean isNeg = isANeg ^ isBNeg;
				MultDivMod multDivMod = new MultDivMod("1", "*");

				if (aToken.contains("*") || aToken.contains("/")) {
					String[] aComponents = parseSingle(aToken);
					for (int x = 0; x < aComponents.length; x++) {
						multDivMod.append(aComponents[x]);
						System.out.println("appending: " + aComponents[x]);
					}
				} else {
					multDivMod.append(aToken);
					System.out.println("appending: " + aToken);
				}

				multDivMod.append(op);

				if (bToken.contains("*") || bToken.contains("/")) {
					String[] bComponents = parseSingle(bToken);
					for (int x = 0; x < bComponents.length; x++) {
						if (bComponents[x].equals("*")) {
							multDivMod.append("/");
						} else if (bComponents[x].equals("/")) {
							multDivMod.append("*");
						} else {
							multDivMod.append(bComponents[x]);
							System.out.println("appending: " + bComponents[x]);
						}
					}
				} else {
					multDivMod.append(bToken);
				}

				if (isNeg) {
					addSubBit.append("-");
					System.out.println("final " + multDivMod.evaluateFinal());
					addSubBit.append(multDivMod.evaluateFinal());
				} else {
					addSubBit.append("+");
					System.out.println("final " + multDivMod.evaluateFinal());
					addSubBit.append(multDivMod.evaluateFinal());
				}

				isBNeg = false;
			}

			isANeg = false;
		}

		return addSubBit.evaluateFinal();

	}

	public static void main(String[] args) {
		// System.out.println(standardize("1.2 * varName .
		// hasSpaceBeforeAndAfterDot . [already has bracket] * -88 + 'hello!
		// Leave the spaces and CaPiTaLiSaTiOn alone!'"));
		// System.out.println(simplify("5+8*3"));
		// System.out.println(simplify("5+8*varName+varName+2+VARNAME"));
		// System.out.println(simplify("5+8*varName*varName-7"));
		// System.out.println(simplify("5+8*varName*varName/varName-5*varName+0-0"));
		// System.out.println(simplify("5+8*varName*varName/varName/varName"));
		// System.out.println(simplify("5+8*varName*varName/varName/varName/varName"));
		// System.out.println(simplify("'he'+'llo'+varName"));
		// System.out.println(simplify("'he'+varName+'llo'"));
		// System.out.println(simplify("'he'+''+'llo'"));
		// System.out.println(simplify("1/x+2/x+2/y+4/y+3*x%3-5*x/y+x/y+7*x/y+6/y"));
		// System.out.println(simplify("3*x%3"));
		// System.out.println(evaluate("4*(5*xs+2)"));
//		System.out.println(parseSingle("1++1"));
		// System.out.println(simplify("3/y+x/y"));
		// System.out.println(evaluate("x*(yasd%4+3+4*(3+s)*4/3)+2"));
		 String[] a = parseSingle("5+4-(3*[x.y]+-2)/1");
		 for (int i = 0; i < a.length; i++) {
			 System.out.println(a[i]);
		 }
	}

}
