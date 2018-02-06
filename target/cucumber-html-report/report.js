$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/test.feature");
formatter.feature({
  "line": 1,
  "name": "Grid test",
  "description": "",
  "id": "grid-test",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "gridtest",
  "description": "",
  "id": "grid-test;gridtest",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I navigate to page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I search for jobs",
  "keyword": "And "
});
formatter.match({
  "location": "StepDef.i_navigate_to_webpage()"
});
formatter.result({
  "duration": 9768206857,
  "status": "passed"
});
formatter.match({
  "location": "StepDef.i_search_for_jobs()"
});
formatter.result({
  "duration": 3765442588,
  "status": "passed"
});
formatter.after({
  "duration": 2545369177,
  "status": "passed"
});
});