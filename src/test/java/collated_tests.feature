Feature: Collator


Scenario: Domain Term TestStatus
* Outcomes     # ListOfObject DomainTermValues
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
| Name   | TestStatus  | Notes                                    |
| TestC  | Pass        | Should show up last, since a new test    |
| TestA  | Fail        | Should switch to Fail, but not new test  |
When end run results are  # ListOfObject TestResultIn 
| Name   | TestStatus  | Is New  |
| TestA  | Fail        | false   |
| TestB  | NotRun      | false   |
| TestC  | Pass        | true    |

Data DomainTermValues 
| Name   | Default  | Datatype  | Notes     |
| Value  |          | String    |           |
| Valid  | true     | boolean   |           |
| Notes  |          | String    | comments  |

Import 
| Datatype    | ConversionMethod       |
| TestStatus  | TestStatus.valueOf($)  |
