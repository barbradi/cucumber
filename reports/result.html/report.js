$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/demo.feature");
formatter.feature({
  "name": "Belly",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "a few cukes",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I have 42 cukes in my belly",
  "keyword": "Given "
});
formatter.match({
  "location": "Stepdefs.I_have_cukes_in_my_belly(int)"
});
formatter.result({
  "status": "passed"
});
});