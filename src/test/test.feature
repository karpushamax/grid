Feature: Grid test


#Scenario: gridtest
#
#Given I navigate to page
#Then I log in
#And I search for jobs
#Then I apply for jobs



Scenario: totaljobs
Given I navigate to totaljobs and log in
Then I search for jobs in London
And I apply for applicable jobs
