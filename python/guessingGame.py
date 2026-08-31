import random 

max = int(input('Enter a max number :- '))
min = int(input('Enter a min number :- '))

is_valid_range = True

if max < min :
    is_valid_range = False

while True :
    if not is_valid_range :
        max = int(input('That vas invalid max, Enter valid max again :- '))
        min = int(input('That was invalid min, Enter vaild min again :- '))
        is_valid_range = True

    