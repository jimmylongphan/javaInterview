def find_substring(string):
    initial_character = string[0]

    for index in range(1, len(string)):
        character = string[index]

        if character == initial_character:
            substring = string[:index]
            if substring == string[index:index * 2]:
                if verify_substring(substring, string):
                    return substring

    return string


def verify_substring(substring, string):
    for index in range(0, len(string), len(substring)):
        if string[index:index + len(substring)] != substring:
            return False

    return True


def count_substring(substring, string):
    return len(string) / len(substring)


def solution(string):
    return count_substring(find_substring(string), string)

