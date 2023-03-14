public class Process {
    public String name;
    public int size;

    public Process(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

}
