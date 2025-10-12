from itertools import combinations
from knapsack_item import KnapsackItem
def main():
    max_knapsack_weight = 7
    # Create the items that will be in the knapsack with there given names and weights
    item1 = KnapsackItem("a", 1, 1)
    item2 = KnapsackItem("b", 3, 4)
    item3 = KnapsackItem("c", 4, 5)
    item4 = KnapsackItem("d", 5, 7)

    # Put items in the knapsack
    knapsack = [item1, item2, item3, item4]

    # Create a list of ((2^n)-1) combinations within the knapsack set (power set)
    combinations_list = []

    knapsack_len = len(knapsack)

    # Append all combinations into a 2D list
    while knapsack_len > 0:
        combinations_list.append(list(combinations(knapsack, knapsack_len)))
        knapsack_len -= 1

    best_combination = []
    biggest_val = 0
    cur_val = 0
    # Go through the combination list and find the total weights and values of each combination,
    # checking if the total weight is <= the allotted weight. If it is, we keep track of the 
    # largest value we find and the combination that provided that largest value. 
    for row in combinations_list:
        for combination in row:
            total_weight = 0
            total_value = 0
            for element in combination:
                print(element.name, end=" ")
                total_weight += element.weight
                total_value += element.value
            print("w=", total_weight, "v=", total_value, end=" ")
            print()
            if total_weight <= max_knapsack_weight:
                if total_value > biggest_val:
                    biggest_val = total_value
                    best_combination = combination


    print(biggest_val)

    for element in best_combination:
        print(element.name)



if __name__ == "__main__":
    main()
