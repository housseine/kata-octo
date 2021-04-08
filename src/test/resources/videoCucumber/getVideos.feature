Feature: get Videos with Video Service
 Retrieve Videos By Tag And Level

 Scenario: Retrieve Videos By Tag And Level
  Given level "EASY" tags
   |POURCENTAGE|
   |CALCUL|
  When I Call the service RetrieveVideosByTagAndLevel
  Then I should get 2 videos

 Scenario: Retrieve all videos
  Given no level and no tags
  When I Call the service RetrieveVideosByTagAndLevel
  Then I should get 2 videos

 Scenario: Retrieve videos with tags only
  Given tags
   |POURCENTAGE|
  When I Call the service RetrieveVideosByTagAndLevel
  Then I should get one 1 video

 Scenario: Retrieve videos with level only
  Given level "EASY"
  When I Call the service RetrieveVideosByTagAndLevel
  Then I should get one 1 video