# dict = {
#     "name" : "Xavier Brooke",
#     "city" : "Delhi",
#     "age" : 20
# }

# print(dict.get("name"))
# print(dict.keys())

# for key in dict :
#     print(f"key -> {key} & Value -> {dict.get(key)}")


# MY_SET = {"key", "value", "mango", "mango", "mango", "value", "key"}
# print(len(MY_SET))

# f = open('sampel.txt', 'w')
# f.write("This para has been written through .py file")

# f = open('sampel.txt', 'r')
# data = f.read()
# print(f"Data inside file = {data}")
# print("Hello World")

# import asyncio

# async def getData() :
#     print('inside getData function')
#     f = open('sample.txt', 'r')
#     data = await f.read()
#     print(f'data inside file {data}')
#     f.close()

# getData()

# def replaceJava(data) :
#     return data.replace('Java', 'Python')

# def isPresent(data, word) :
#     return data.index(word) != -1
    

# with open('practice.txt', 'w+') as f :

#     # Writing to the file
#     f.write('Hi everyone\n')
#     f.write('we are learning File I/O\n')
#     f.write('using Java.\n')
#     f.write('I like programming in Java.')

#     # Replacing Java with Python
#     f.seek(0)
#     data = f.read()
#     data = replaceJava(data)
#     f.seek(0)
#     f.write(data)

#     # Search for word 'learning'
#     f.seek(0)
#     data = f.read()
#     print(f"Is learning present in the file :- {isPresent(data, 'learning')}")
#     f.seek(0)

# class Complex :
#     def __init__(self, real, img) :
#         self.real = real
#         self.img = img

#     def __add__(self, other):
#         return Complex(self.real+other.real, self.img+other.img)

#     def print(self) :
#         print(f"{self.real}i + {self.img}j")

# c1 = Complex(1, 2)
# c1.print()
# c2 = Complex(2, 3)
# c2.print()
# c3 = c1 + c2
# print("-".center(10, '-'))
# c3.print()
# print("-".center(10, '-'))

# char = 'A'
# print(ord(char))