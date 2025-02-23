Feature: Collator


Scenario: Domain Term TestStatus
* Outcomes     # ListOfObject ValueValid
| Value    | Notes                          |
| Pass     |                                |
| Fail     |                                |
| Disable  |                                |
| Abort    | Status has not been seen       |
| NotRun   | test was not run in prior run  |
# NotRun will not appear in the LogResult, it will just not show up 

Data LogResult
| Name        | Default  | Datatype    | Notes             |
| Name        |          | String      | Test name         |
| TestStatus  | Abort    | TestStatus  | Enum of outcomes  |
| Notes       |          | String      | Comment on value  |

Data TestResultIn
| Name        | Default  | Datatype  | Notes                       |
| Name        |          | String    | Test name                   |
| TestStatus  | Pass     | TestStatus| Enum of outcomes            |
| Is New      | false    | boolean   | Is this a test seen before  |


Scenario:   Two Runs 
Given log contains # ListOfObject LogResult 
| Name | TestStatus | 
| TestA  | Pass     |
| TestB  | Fail     |
When end run results are # ListOfObject TestResultIn
| Name   | TestStatus  | Is New  |
| TestA  | Pass        | true    |
| TestB  | Fail        | true    |
Given log contains # ListOfObject LogResult 
| Name   | TestStatus  | 
| TestC  | Pass        | 
| TestA  | Fail        | 
When end run results are  # ListOfObject TestResultIn 
| Name   | TestStatus  | Is New  |
| TestA  | Fail        | false   |   # Should now be fail as reported in new log
| TestB  | NotRun      | false   |   # Should show up NotRun, since not in log
| TestC  | Pass        | true    |   # Should show up last, even though first in log

Data ValueValid
| Name   | Default  | Datatype  | Notes     |
| Value  |          | String    |           |   # Some other commetn
| Valid  | true     | boolean   |           |
| Notes  |          | String    | comments  |




Import 
| Datatype    | ConversionMethod       |
| TestStatus  | TestStatus.valueOf($)  |
