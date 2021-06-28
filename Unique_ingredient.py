

class Meal:
    def __init__(self,name,ingredient):
        self.name = name
        self.ingredient = ingredient


meals = []
meals.append(Meal("Burger",['Lettuce','Patty','Onion']))
meals.append(Meal("Salad",['Lettuce','Cucumber','Onion']))
meals.append(Meal("Mexican Burger",['Lettuce','Onion','Patty']))
meals.append(Meal("Greek Salad",['Lettuce','Cucumber','Onion']))

dict_meals = {}
for i in meals:
    meal_name = [i.name]
    ingredient= i.ingredient
    ingredient_list = [''.join(sorted(i.lower())) for i in ingredient]
    ingredient_list = sorted(ingredient_list)
    if str(ingredient_list) in dict_meals:
        value = dict_meals[str(ingredient_list)]
        value = value.append(meal_name)
    else:
        dict_meals[str(ingredient_list)] = [meal_name]
count = 0
print(dict_meals)
for key,value in dict_meals.items():
    if(len(value) >= 2):
        count+=1
print(count)
