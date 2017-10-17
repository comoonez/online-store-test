Feature: Filtering feature
	Filter mens shoes by brands "Skechers" and "Firetrap" and price in range 30 - 60 EUR. Check if items are correctly filtered.

Scenario: Select specific shoes
Given I have navigated to sportsdirect homepage
	And selected mens category
	And choose mens shoes
	And select specific brands
	And set a min price 30 euro
	And set a max price 60 euro
When I filter the list of items
Then I see only specific brand shoes
	And dont see shoes with the price less than 30 euro and more than 60 euro