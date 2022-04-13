// Assignment #: 10
//  Name: Rhea Mane
//  StudentID: 1222796497
//  Lecture Time: T/Th 1:30
//  Time took you to complete the assignment: 15 hours
//  Description: (Description of each file/class)
//  Consists the table object with the number of guests and name and the toString

public class Table {
    String name;
    int guests;
    Table next;

    public Table(int n, String name){
        this.name = name;
        guests = n;
        next = null;
    }

    public String toString(){
        return "\nReservation for " + name + ": party of "
                + guests + ".\n";
    }

// Empty Table inherits the Table class to
    public static class EmptyTable extends Table{

        public EmptyTable() {
            super(-1, "");
        }
    }
}
