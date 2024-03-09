public class CompanyHashMap {
    private static final double LOAD_FACTOR = 0.75;
    private final int INITIAL_CAPACITY = 4;
    private int size = 0;
    private Entry[] array = new Entry[INITIAL_CAPACITY];

    private static class Entry {

        CompanyKey key;
        Company value;
        Entry next;

        public Entry(CompanyKey key, Company value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private int getElementPositon(CompanyKey companyKey, int Arraylength) {
        return Math.abs(companyKey.hashCode() % Arraylength);
    }

    public void put(CompanyKey key, Company company){
        if (size >= (array.length*LOAD_FACTOR)) increase_array();
        boolean put = put(key,company,array);
        if (put) size++;
    }

    public boolean put(CompanyKey key, Company company, Entry[] dst) {
        int position = getElementPositon(key, dst.length);
        Entry existedElement = new Entry(key, company, null);
        if (dst[position] == null) {
            dst[position] = existedElement;

        } else {
            while (true) {
                if (existedElement.key.equals(key)) {
                    existedElement.value = company;
                    return true;
                }
                if (existedElement.next != null) {
                    existedElement.next = new Entry(key, company, null);

                    return true;
                }
                existedElement = existedElement.next;
            }
        }
        return false;
    }

    public boolean remove(CompanyKey key, Company company) {
        int position = getElementPositon(key, array.length);
        Entry existedElement = new Entry(key, company, null);
        if (existedElement.key.equals(key)) {
            existedElement = existedElement.next;
            size--;
            return true;
        } else {
            while (existedElement != null) {
                Entry nextElement = existedElement.next;
                if (nextElement == null) {
                    return false;
                }
                if (nextElement.key.equals(key)) {
                    size--;
                    return true;
                }
                existedElement = nextElement.next;
            }
        }
        return false;
    }
    public void increase_array(){
        Entry[] newarray = new Entry[array.length * 2];
        for (Entry entry: array){
            Entry existedElement = entry;
            while (existedElement != null){
                put(existedElement.key, existedElement.value, newarray);
                existedElement = existedElement.next;
            }
        }
        array = newarray;
    }
    public void Print(){
        for(Entry entry: array){
            if (entry !=null){
                System.out.println(entry.key + ":" + entry.value);
                while (entry!=null){
                    Entry nextElement = entry.next;
                    if (nextElement != null) System.out.println(nextElement.key + ":" + nextElement.value);

                }
            }
        }
    }
}