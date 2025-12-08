def getFileNameQueue(file_names_string):
    file_queue = file_names_string.split(", ")

    return file_queue


def getFileContentsHashMap(file_names):
    file_name_queue = getFileNameQueue(file_names)
    file_hash_table = {}
    while len(file_name_queue) > 0:
        file_name = file_name_queue.pop(0)
        lines_array = []

        try:
            with open(file_name) as f:
                for lines in f:
                    lines_array.append(lines.strip())
                file_hash_table.update({file_name: lines_array})

        except FileNotFoundError:
            print("Error: '" + file_name + "' does not exist")
        except:
            print("Error: An unknown error occured")
    print(file_hash_table)

def searchHashMapForTerm(file_hash_table, search_term):
    print("meme")

def grepFunction(file_names, search_term):
    file_name_queue = getFileNameQueue(file_names)
    found_item_in_file = [False] * len(file_name_queue)
    found_item_in_file_idx = 0
    while len(file_name_queue) > 0:
        file_name = file_name_queue.pop(0)
        print(file_name)

        try:
            with open(file_name) as f:
                for lines in f:
                    if search_term in lines:
                        found_item_in_file[found_item_in_file_idx] = True
                        found_item_in_file_idx += 1
                        print("YES")
                        break

            print(found_item_in_file)

        except FileNotFoundError:
            print("Error: '" + file_name + "' does not exist")
        except:
            print("Error: An unknown error occured")


def main():
    getFileContentsHashMap("file_1, file_2", "sd")


if __name__ == "__main__":
    main()
