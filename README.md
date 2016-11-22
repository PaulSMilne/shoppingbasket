An interesting challenge that let me work out how to navigate through a complicated method that uses for loops and if statements - the bogoffDiscount method in the ShoppingBasket class.

I learned a couple of interesting methods I wasn't aware of before:

* the removeAll method for lists lets you compare a two lists and remove the common elements from one of them. I used this in the removePurchases method (ShoppingBasket.java:27) to take items out of the basket. I passed an argument as a single item into an ArrayList and then used to determine what to remove from the basket list by comparing the two. It found the common item and successfully removed it.

* the subList method of the List class lets you specify a subset of a list to create a new list from. You pass it an argument of an inclusive starting index and an exclusive ending index. 
 * I created a list of all the bogoff prices and sorted it using the Collections.sort(list) method so it always has the cheapest item in index[0] and increasing in price from there. 
 * Using the list .size method I got the length of the total list of bogoff prices, and halved it. This gives me an integer that acts as the upper ending index for the subList method. Because division returns an integer and throws away the remainder, this will work for both even and odd numbers of prices, because for odd number of prices there will never be an even match between high and low prices. I used 0 as the inclusive starting index because that is where the lowest price always lives.
 * For example, if there are 2 items, division gives int 1 which becomes the exclusive end index for the subList method, so it returns a list with one item from index[0], always the lowest price. If there are 3 items, exactly the same happens, which is fine as only two of the high/low prices can ever match up in BOGOF.
 * If there are 4 items, division gives 2, which becomes the exclusive end index, returning a list of the two items at [0] and [1]. And so on. 