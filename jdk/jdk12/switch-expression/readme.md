Switch Expression:
------------------
**What is the difference between Switch Statement and Switch Expression?**

| Type               | Switch Statement                                                                          | Switch Expression                                                 |
|--------------------|-------------------------------------------------------------------------------------------|-------------------------------------------------------------------|
| Fall-through       | Accidental fall-through - This can be prevented using a break statement.                  | No fall-through - No usage of break statement.                    |
| Combined Constants | Supported.                                                                                | Not Supported.                                                    |
| Scope of Variables | Variable Scooping - variables defined in the statement are visible at local method level. | Block scoping - variables defined are visible only in the blocks. |
| Return Value       | Not Supported - Return Value.                                                             | Supported - Return yield                                          |

Reference Links for the above comparision are:

https://stackoverflow.com/questions/65657169/what-are-switch-expressions-and-how-are-they-different-from-switch-statements
https://www.agileconnection.com/article/switch-expressions-java-14-add-simplicity-and-agility#:~:text=The%20default%20scoping%20of%20a,is%20assigned%20the%20expression%20value.

