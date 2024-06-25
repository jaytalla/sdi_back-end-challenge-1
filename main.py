import math

numOfSeat = 0

sizeSmall = [5, 5000, 'S']
sizeMedium = [10, 8000, 'M']
sizeLarge = [15, 12000, 'L']

# this is if the price and size are fixed
# I already added the optional part here where the price and size can be dynamic or edited
def GetTheCheapestSeat(numOfSeat):
    if numOfSeat <= 0:
        print("You need to input number above 0.")
        return None
    
    small  = math.ceil(numOfSeat / sizeSmall[0])
    medium = math.ceil(numOfSeat / sizeMedium[0])
    large = math.ceil(numOfSeat / sizeLarge[0])

    # Increment if lower than target
    if (small * sizeSmall[0]) < numOfSeat: 
        small += 1
    if (medium * sizeMedium[0]) < numOfSeat: 
        medium += 1
    if (large * sizeLarge[0]) < numOfSeat: 
        large += 1 

    # cant use this one
    # cheapest = min(small * sizeSmall[1], medium * sizeMedium[1], large * sizeLarge[1])

    # Calculate the cost for each option
    cost_small = small * sizeSmall[1]
    cost_medium = medium* sizeMedium[1]
    cost_large = large * sizeLarge[1]

    cheapestSize = ""
    multiplierCount = 0
    totalPrice = 0

    if cost_small <= cost_medium and cost_small <= cost_large: 
        cheapestSize = sizeSmall[2] # to get the size letter
        multiplierCount = small # to get the 'M x 3' part in the console
        totalPrice = cost_small
    elif cost_medium <= cost_small and cost_medium <= cost_large:
        cheapestSize = sizeMedium[2]
        multiplierCount = medium 
        totalPrice = cost_medium
    else:
        cheapestSize = sizeLarge[2]
        multiplierCount = large
        totalPrice = cost_large

    print(f"{cheapestSize} x {multiplierCount}\nTotal = PHP {totalPrice}")



numOfSeat = input("Please Input number (seat): ")
GetTheCheapestSeat(int(numOfSeat))


            
        