$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/FIrst.feature");
formatter.feature({
  "line": 1,
  "name": "As a Tester",
  "description": "I want to automate the App functionality\nSo that I can test the app",
  "id": "as-a-tester",
  "keyword": "Feature"
});
formatter.before({
  "duration": 45689403919,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "First scenario",
  "description": "",
  "id": "as-a-tester;first-scenario",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "I am on App landing page",
  "keyword": "Given "
});
formatter.match({
  "location": "First.iAmOnAppLandingPage()"
});
formatter.result({
  "duration": 99651611,
  "status": "passed"
});
formatter.after({
  "duration": 245165303,
  "status": "passed"
});
});