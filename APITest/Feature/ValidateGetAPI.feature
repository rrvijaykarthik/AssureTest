Feature: Validate getAPI request

Scenario Outline: Send and Validate GET API Request
     When Send GET API Request
     And Check if the response is successfull
     Then Validate using Name <Name> and "<CanRelist>" and <ProName> and <ProDescription>
     Examples: 
     | Name         	  | CanRelist     |    ProName        |   ProDescription |
     | "Carbon credits" | true        |"Gallery"        |  "Good position in category" |
     | "Carbon credits" | false       |"Gallery"        |  "Good position in category" |
     | "Carbon credits" | true        |"Gallery"        |  "Good Positionincompany" |
     | "Carbon credits" | true        |"Feature"        |  "Better position in category" |
     | "Carbon debits" 	| true        |"Gallery"        |  "Better position in category" |
     | "Carbon credits" | true        |"Basic"          |  "Lowest position in category" |
     | "Carbon credits" | true        |"Feature Combo"  |  "Best position in category \nIncludes benefits of Feature \nHighlights listing in search results" |
     | "Carbon credit"  | true        |"Gallery"        |  "Best position in category \nIncludes benefits of Feature \nHighlights listing in search results" |
     | "Carbon credits" | true        |"Feature Combo"  |  "Best position in category \nIncludes benefits of Feature \nHighlights listing in search results" |
     
    