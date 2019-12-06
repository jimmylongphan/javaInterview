def list_to_int(list_of_numbers):
    number = 0

    for element in list_of_numbers:
        number *= 10
        number += element

    return number


def is_divisible_by_three(list_of_numbers):
    return sum(list_of_numbers) % 3 == 0


def delete_element(list_of_numbers):
    list_of_numbers.sort()

    total = sum(list_of_numbers)
    for index, value in enumerate(list_of_numbers):
        if (total - value) % 3 == 0:
            del list_of_numbers[index]
            return

    del list_of_numbers[0]
    return


def solution(numbers):
    while is_divisible_by_three(numbers) == False:
        delete_element(numbers)

    return list_to_int(sorted(numbers, reverse=True))

