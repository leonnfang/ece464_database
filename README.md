# ece464_database
This the final project for ECE464-Database.

a recipe wizard is implemented for this final project. The following features are implemented.

more details can be found in the [DataQueryApi.java](./RecipeWizard/src/main/java/com/ece464/recipewizard/Controller/DataQueryApi.java) 
### search by the name of the recipe
a string can be inputted, and all recipes whose names contain the string will be inputted (case-insensitive)

### search by the name of the ingredient
a string can be inputted, and all recipes whose ingredients contain the string will be inputted (case-insensitive)

### search by the exact the name of the recipe
a string can be inputted, and the recipe whose name matches with the input string exactly will be returned

### get the list of names of recipes in the database
the list of names of all recipes will be returned

### get the ingredients of a recipe by an exact name of a recipe
a string can be inputted, and the ingredients list of the inputted name will be returned

### get the recommended recipes
three randomly selected recipes will be returned

### insert a recipe to the database
the information of a recipe can be inputted and inserted to the database

