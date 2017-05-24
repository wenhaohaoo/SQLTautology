# SQLTautologyDetection (Description by Ian)

1. Make an ExpressionDescription class with the following properties/fields:
i. public string LeftExpression
ii. public string RightExpression
iii. public string ComparatorString
iv. public string OriginalDescription
v. public bool IsSuccessful
And having a constructor which takes a string input to be assigned to OriginalDescription like this:
i. public ExpressionDescription (string input) {
OriginalDescription = input;
//The rests of the code
IsSuccessful = true; //only if the input is valid
}

2. Make an ExpressionHelper class with the following static(?) methods:
i. public static bool IsValidNumber (string numberExpression)
ii. public static bool IsValidVariable (string variableExpression)
iii. public static bool IsValidString (string stringExpression)
iv. public static string IsValidNull (string nullExpression)
v. public static bool IsValidComparator (string comparatorExpression)

vi. public static string[] ParseSingle (string expression) -> can change the output from string[] to ArrayList<string> too
vii. public static bool Standardize (string basicExpression)
viii. public static bool IsValid (string basicExpression)
ix. public static string Simplify (string basicExpression)
x. public static string Evaluate (string expression)
xi. public static ExpressionDescription Parse (string fullExpression)
xii. public static bool IsTautology (string fullExpression)

3. Let's define the following:
i. valid [number] just like valid number in C# or Java: 
a. 1.234
b. 11125
c. -1234
d. -1.234
but WITHOUT suffix!
a. 1.234f is INVALID
and also there should NOT be any whitespace in before or after dot:
a. 1. 23 is INVALID
b. 1 .23 is INVALID
and beware of multiple dots:
a. 1.2.3 is INVALID
or any additional square brackets:
a. [5.123] is INVALID

IMPORTANT: in order for IsValidNumber to return true, a the [numberExpression] must be in a VALID form

ii. [variable] as something written just like variable in C# or Java: 
-> Valid variables:
a. variableName
b. variable_Name
c. variableName123
d. _variableName
e. and so on...
-> Invalid variables:
a. 12variableName (having number in front)
b. int (because int is a keyword)!!!
c. and other rules... basically has to be only alphanumeric or underscore to be valid

IMPORTANT: get the list of keywords for SQL Server to avoid!

with the following additions:
-> The following are VALID variables:
a. [myVariableName]
b. [my Variable Name]
c. myVariableName.havingDot.andAnotherDot
d. myVariableName.[havingDot].andAnotherDot
e. [myVariableName].[havingDot].[andAnotherDot]
f. [my Variable Name].[havingDot].andAnotherDot
g. myVariableName.  [havingDot]   .andAnotherDot
h. [int].[nvarchar].[number].[string]

Note that if variable name is put in between [], it is valid even it is written with/without space AS LONG AS THE SPACE IS NOT IN THE BEGINNING OR THE END. 
And that variable names may be chained using dot (.)
After and before the dot, there might be white space, and that's OK
Keywords used in a square bracket is OK

-> The following are INVALID variables:
a. my Variable Name (INVALID, because not having square brackets [my Variable Name])
b. [myVariableName.havingDot] (INVALID, because having single pair of square brackets for two chained names, should be [myVariableName].[havingDot])
c. [myVariableName].having Dot (INVALID, because it is only partially valid - only the first name is OK, should be [myVariableName].havingDot)
d. [ myVariableName] (INVALID, because it has extra space at the beginning)
e. [myVariableName ] (INVALID, because it has extra space at the end)

-> The following refer to the SAME variables with different way of writings:
a. myVariableName.havingDot and myVariableName.[havingDot] and [myVariableName].[havingDot] and [myVariableName].havingDot
b. MYVariABleName  .HAvingDot and [myvariablename]  .havingdot and [MYVARIABLENAME]   .    HAVINGDOT and [MyVaRiAbLeNaMe].HaViNgDoT and myVariableName.havingDot
basically, [variable]s are case INSENSITIVE and white space INSENSITIVE!

-> The following refer to DIFFERENT variables:
a. myVariableName.havingDot and havingDot and myVariableName

IMPORTANT: in order for IsValidVariable to return true, a the [variableExpression] must be in a VALID form     

iii. valid [string] can be any string but must be started and ended with apostrophe, i.e. 'this is a valid string !^@!#*^'
If there is apostrophe inside the [string], it must be written twice continuously, i.e. 'that''s what I want to say'
The following are invalid:
a. 'this is not a valid string (not closed with aposthrope)
b. 'this' ' is incorrect' (has apostrophe inside the [string] which is not written twice continuously - having space in between)

IMPORTANT: in order for IsValidString to return true, a the [stringExpression] must be in a VALID form

iv. valid [null] must be exclusively written with the keyword NULL:
a. null or
b. NULL or
c. NuLl
it is case INSENSITIVE, but cannot be written otherwise:
a. [NULL] INVALID
b. something.NULL INVALID

IMPORTANT: in order for IsValidNull to return true, a the [nullExpression] must be in a VALID form

v. [comparators] can be any of the following signs: =, >, <, >=, <=, !=, <>      

IMPORTANT: in order for IsValidComparator to return true, a the [comparatorExpression] must be in a VALID form

vi. [basicExpression] is an expression without comparators or brackets and only having any of the VALID inputs, 
and having only the following operator signs: +, -, *, /, %, & (single), | (single).
The following operator signs, for example, must not be part of [basicExpression]: &&, ||, ^, (, ), --, =, >, >=, <=, ?, ... and so on
Examples:
a. 1.1 + -5.32 * -7.56
b. -1.2 * varName + varName2 % 5 
c. 'hello!' + 23 * varName.hasDot (Yes, I know this is wrong, but just define this as basicExpression as of now, later we will talk about this)

vii. [expression] is an expression without comparators, but may have brackets:
Examples:
a. (1.1 + 5.32 * 7.56) + (1.2 * varName + varName2 % 5)

viii. [fullExpression] in an expression which may have brackets or comparators:
Examples:
a. (1.1 + 5.32 * 7.56) + (1.2 * varName + varName2 % 5) >= 7 * 123.1 + varName3.[has dot and space].NumberValue

ix. [component]s are parts which compose an [expression], they can be any of the following:
a. bracket [expression] 
example: (1.2 * varName + varName2 % 5)
b. valid [number]s
c. valid [string]s
d. valid [variable]s
e. valid [null]s
f. valid [operator]s
basically anything except [comparators]

4. The following are the behavior of each method:

i. public static bool IsValidNumber (string numberExpression)
check if numberExpression is valid, as previously explained

ii. public static bool IsValidVariable (string variableExpression)
check if variableExpression is valid, as previously explained

iii. public static bool IsValidString (string stringExpression)
check if stringExpression is valid, as previously explained

iv. public static string IsValidNull (string nullExpression)
check if nullExpression is valid, as previously explained

v. public static bool IsValidComparator (string comparatorExpression)
check if comparatorExpression is valid, as previously explained

vi. public static string[] ParseSingle (string expression) -> can change the output from string[] to ArrayList<string> too
change an expression into its basic [component]s. 
Examples:
(1.1 + 5.32 * 7.56) + 1.2 * varName + varName2 % 5 should become:
[0] (1.1 + 5.32 * 7.56)
[1] +
[2] 1.2
[3] *
[4] varName
[5] +
[6] varName2
[7] %
[8] 5

vii. public static string Standardize (string basicExpression)
Is to change a basic expression to a standardized form for ease of comparison later on. The change should include:
a. putting square bracket to every detected, valid, [variable]:
Example:
1.2 * varName . hasSpaceBeforeAndAfterDot . [already has bracket] *    -88 + 'hello! Leave the spaces and CaPiTaLiSaTiOn alone!' 
should become:
1.2 * [varName] . [hasSpaceBeforeAndAfterDot] . [already has bracket] *    -88 + 'hello! Leave the spaces and CaPiTaLiSaTiOn alone!' 
b. make all [variable] names capitalized:
Example:
1.2 * [varName] . [hasSpaceBeforeAndAfterDot] . [already has bracket] *    -88 + 'hello! Leave the spaces and CaPiTaLiSaTiOn alone!' 
should become:
1.2 * [VARNAME] . [HASSPACEBEFOREANDAFTERDOT] . [ALREADY HAS BRACKET] *    -88 + 'hello! Leave the spaces and CaPiTaLiSaTiOn alone!' 

c. deletion of whitespaces in anything but string value.
Example:
1.2 * [VARNAME] . [HASSPACEBEFOREANDAFTERDOT] . [ALREADY HAS BRACKET] *    -88 + 'hello! Leave the spaces and CaPiTaLiSaTiOn alone!' 
should become:
1.2*[VARNAME].[HASSPACEBEFOREANDAFTERDOT].[ALREADY HAS BRACKET]*-88+'hello! Leave the spaces and CaPiTaLiSaTiOn alone!'         

viii. public static bool IsValid (string basicExpression)
Is to check is a [basicExpression] is valid. 
For a [basicExpression] to be valid, 
-> It must consists of only allowable [component]s AND its operation cannot have mixed of:
a. [string] and [number]
Example:
'hello' + 5 + 'so strict!' (INVALID)
b. [string]/[number]/[variable] and [null]
Examples:
'hello' + NULL (INVALID)
5 + NULL (INVALID)
varName.hasDot + NULL (INVALID)

-> If it consists of [string], the only allowed operator is '+':
Examples:
'hello?' + 'any body home?' (VALID)
'hello?' - 'any body home?' (INVALID)
'hello?' + varName - 'any body home?' (INVALID)

-> If it is a consecutive operators, it can only be +-

-> It is allowed to have mixed of other types (i.e. [string] and [variable], [number] and [variable], etc)

ix. public static string Simplify (string basicExpression)
Is to simplify a basicExpression into its SIMPLEST, MATHEMATICAL, form.
Preferrably if the expression can be rearranged
Examples:
a. 5+8*3 -> 29
b. 5+8*varName+varName+2 -> 7+9*varName
c. 5+8*varName*varName-7 -> -2+8*varName*varName (note that we DO NOT use power sign varName^2)
d. 5+8*varName*varName/varName-5*varName+0-0 -> 5+3*varName
e. 5+8*varName*varName/varName/varName -> 13
f. 5+8*varName*varName/varName/varName/varName -> 5+8/varName
g. 'he'+'llo'+varName -> 'hello'+varName
h. 'he'+varName+'llo' -> 'he'+varName+'llo' (cannot be further simplified)
i. 'he'+''+'llo' -> 'hello' (remove every empty string)

x. public static string Evaluate (string expression)
Use Simplify recursively (well, as if this can be done... sorry, maybe this is not that simple... :() 
to get the most simplified form of an expression (which may consists of brackets):
a. (5+8)*3 -> 39
b. (varName*3.12*varName)+4*(5+7)+(5*varName)*varName -> 8.12*varName*varName+48
c. (2*varName+3)*varName -> 2*varName*varName + 3*varName

xi. public static ExpressionDescription Parse (string fullExpression)
There must only be ONE OR LESS [comparator] for a [fullExpression] to be valid
The function simple parse a [fullExpression] into its LeftExpression, RightExpression, and ComparatorString 

xii. public static bool IsTautology (string fullExpression)
Probably the most difficult part. 
Input [fullExpression], use Parse inside, then depending on the [comparator], check if the comparison always true.
If it is always true, then return true. Otherwise, return false.
IMPORTANT: every [variable] will be treated as non-empty
Examples:
-> 5+8*varName=8*varName+5
-> 1=1
-> 'hello'+varName='he'+''+llo'+varName
-> 2>1
-> 2*varName>varName


sqlString = "select * from xxy where officerName = \'" + userInput + "\'";
userInput = "\' OR 2>=1; DELETE from StupidTable; drop --"; 
