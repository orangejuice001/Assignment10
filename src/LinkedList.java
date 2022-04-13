// Assignment #: 10
//  Name: Rhea Mane
//  StudentID: 1222796497
//  Lecture Time: T/Th 1:30
//  Time took you to complete the assignment: 15 hours
//  Description: (Description of each file/class)
// This is the linked list class, it contains all the methods like adding a table, removing a reservation from the front middle and back.
// It also consists methods to get the position of the table, the number of parties with a particular number of guests
// And it also consists of the list reservations method

public class LinkedList {
    Table first;
    int size;

    public LinkedList() {
        first = null;       // empty list created
        size = 0;
    }

    public void add(int numberOfGuests, String name) {
        Table newGuest = new Table(numberOfGuests, name);
        if (first == null) {
            first = newGuest;
        } else {
            Table pointer = first;
            while (pointer.next != null)
                pointer = pointer.next;

            pointer.next = newGuest;
        }
        size++;
    }

    /**
     * removes the first element of the linked list
     *
     * @return returns the removed element
     */
    public Table removeFirst() {
        if (first == null) {
            return new Table.EmptyTable();
        } else {
            Table current = first;
            first = first.next;
            size--;
            return current;
        }
    }

    /**
     * Removes the last element of the linked list
     *
     * @return returns the removed element
     */
    public Table removeLast() {
        Table current = first;
        Table prev = null;
        while (current.next != null) {
            prev = current;
            current = current.next;
        }
        prev.next = null;
        return current;

    }

    /**
     * Removes an element from the middle of the linked list
     *
     * @param name - removes the table element with the same name
     * @return returns removed element
     */
    public Table removeMiddle(String name) {
        Table current = first;
        Table prev = current;
        while (current != null) {

            if (current.name.equals(name)) {
                first.next = prev;
                prev.next = current.next;
                return current;
            } else {
                prev = current;
                current = current.next;
            }
        }

        return new Table.EmptyTable();
    }

    /**
     * The main method which calls all the other remove methods
     *
     * @param name - the name to be removed from the linked list
     * @return returns the removed element
     */
    public Table removeGuest(String name) {
        if (first == null) {
            return new Table.EmptyTable();
        } else if (first.name.equals(name)) {
            return removeFirst();                  // Checks if the first element is equal to the given name and calls the removeFirst method
        } else {
            Table current = first;
            while (current != null) {
                if (current.next == null) {
                    if (current.name.equals(name)) {
                        return removeLast();            // Checks if current element is the last element in the linked list and calls the removeLast method
                    } else {
                        return new Table.EmptyTable();  // Returns empty table if no element with that name is found
                    }
                } else {
                    if (current.name.equals(name)) {
                        return removeMiddle(name);      //Calls removeMiddle to remove a reservation from the middle of the linked list
                    } else {
                        current = current.next;
                    }
                }
            }
            return new Table.EmptyTable();
        }
    }

    /**
     * Returns the position of the reservation in the linked list
     *
     * @param name - name of the element who's position needs to be found
     * @return returns the index number of the element
     */
    public int getPosition(String name) {
        int pos = 0;
        Table current = first;
        if (first == null)
            return -1;
        while (current != null) {
            pos++;
            if (current.name.equals(name)) {
                return pos;
            }
            current = current.next;
        }
        return -1;
    }

    /**
     * Gets the number of reservations in the linked list with given numbr of guests
     * @param n - given number of guests
     * @return number of reservations with guests = n
     */
    public int getNumberOfParties(int n) {
        if (first == null)
            return -1;
        int count = 0;
        Table current = first;
        while (current != null) {
            if (current.guests == n) {
                count++;
            }
            current = current.next;
        }
        return count;
    }

    /**
     * Lists out all the reservations
     * @return- toString method of all the table elements
     */
    public String listReservations() {
        String finalStr = "";
        if (first == null) {
            return "No reservations in queue at this time.\n";
        } else {
            int count = 0;
            Table current = first;
            while (current != null) {
                finalStr = finalStr + current.toString() + "\n";
                count++;
                current = current.next;
            }
            finalStr += "Total reservations: " + count + ".\n";
            return finalStr;
        }
    }

}

