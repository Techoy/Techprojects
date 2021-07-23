$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("MyWebPage.feature");
formatter.feature({
  "line": 3,
  "name": "JDBC verification",
  "description": "",
  "id": "jdbc-verification",
  "keyword": "Feature",
  "tags": [
    {
      "line": 2,
      "name": "@uidb"
    }
  ]
});
formatter.scenario({
  "line": 6,
  "name": "Post in UI and Verify in DB",
  "description": "",
  "id": "jdbc-verification;post-in-ui-and-verify-in-db",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "User navigate to \"http://www.techtorialacademy.dev.cc/\"",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "User authorized to make DB calls",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "User adds new post",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "User queries the post from DB",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "http://www.techtorialacademy.dev.cc/",
      "offset": 18
    }
  ],
  "location": "MyWebPage.user_navigate_to(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "MyWebPage.user_authorized_to_make_DB_calls()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "MyWebPage.user_adds_new_post()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "MyWebPage.user_queries_the_post_from_DB()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 13,
  "name": "Post in API and Verify in DB",
  "description": "",
  "id": "jdbc-verification;post-in-api-and-verify-in-db",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 14,
  "name": "User sends post request",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "status code is 201",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "User queries the post from DB",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "MyWebPage.user_queries_the_post_from_DB()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 18,
  "name": "Post in DB and verify in DB",
  "description": "",
  "id": "jdbc-verification;post-in-db-and-verify-in-db",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 19,
  "name": "User authorized to make DB calls",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "User creates post in DB",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "Verify published post in DB  with results queries of DB",
  "keyword": "Then "
});
formatter.match({
  "location": "MyWebPage.user_authorized_to_make_DB_calls()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 24,
  "name": "Post in DB and verify in UI",
  "description": "",
  "id": "jdbc-verification;post-in-db-and-verify-in-ui",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 25,
  "name": "User logs in DB",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "User creates post in DB",
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "Verify published post in DB  with UI posts",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 30,
  "name": "Post in UI and verify in UI",
  "description": "",
  "id": "jdbc-verification;post-in-ui-and-verify-in-ui",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 31,
  "name": "User navigates to UI",
  "keyword": "Given "
});
formatter.step({
  "line": 32,
  "name": "Add new posts in UI",
  "keyword": "When "
});
formatter.step({
  "line": 33,
  "name": "Verify UI posts with UI",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});