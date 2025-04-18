Feature:User on HR Dashboard 

Background: 
Given User already logged in to aplication
|Emailid|password|
|admin@singhsoft.com|Admin@1234|

@dashBoard
Scenario: HR Dashboard title
Given User is on HR dashboard page
When user get the page title
Then User get the page title "HRMS"

@dashBoard
Scenario: HR dashboard page section count
Given User is on HR dashboard page
When user get the page title
Then user get dashboard section 
|Dashboard|
|Candidate Onboarding|
|Generate Documents|
|Employee Profile|
|Attendance Tracking|
|Manage Fund|
|Assets Management|
|E-Exit/Off-Boarding|

And Dashboard section count is 8