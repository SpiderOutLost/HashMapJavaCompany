public class CompanyHashMap {
    private static final double LOAD_FACTOR = 0.75;
    private final int INITIAL_CAPACITY = 2;
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


    public void put(String CompanyLine){
        String[] s = CompanyLine.split(":");
        CompanyKey key = new CompanyKey(s[0]);
        Company company = new Company(s[1]);
        if (size >= (array.length*LOAD_FACTOR)){ increase_array();}
        boolean put = put(key,company,array);
        if (put) size++;

    }

    private boolean put(CompanyKey key, Company company, Entry[] dst) {

        int position = getElementPositon(key, dst.length);
        Entry existedElement = dst[position];
        if (dst[position] == null) {
            Entry entry = new Entry(key, company, null);
            dst[position] = entry;
            return true;

        } else {
            while (true) {
                if (existedElement.key.equals(key)) {
                    existedElement.value = company;
                    return false;
                }
                if (existedElement.next == null) {
                    existedElement.next = new Entry(key, company, null);

                    return true;
                }

                existedElement = existedElement.next;

            }
        }
    }
    public int getSize() {
        return size;
    }

    public boolean remove(String CompanyLine) {
        String[] s = CompanyLine.split(":");
        CompanyKey key = new CompanyKey(s[0]);
        Company company = new Company(s[1]);
        int position = getElementPositon(key, array.length);

        if (array[position] == null) {
            return false;
        }
        Entry secondlast = array[position];
        Entry last = secondlast.next;
            if (secondlast.key.equals(key)) {
                array[position] = last;
                size--;
                return true;
            }
            while (last != null) {
                if (last.key.equals(key)) {
                    secondlast.next = last.next;
                    size--;
                    return true;
                } else {
                    secondlast = last;
                    last = last.next;
                }
            }
            return false;
        }

    public void FindCompany(String CompanyLine) {
        String[] s = CompanyLine.split(":");
        CompanyKey key = new CompanyKey(s[0]);
        Company company = new Company(s[1]);
        int position = getElementPositon(key, array.length); // где на каком месте есть элемент, буду передавать ссылки
        Entry needFindElement = array[position];
        while (needFindElement!= null) {
            if (needFindElement.key.equals(key)) {
                System.out.println("Компания есть");
                return;
            }
            needFindElement = needFindElement.next;
        }
        System.out.println("Компанния не найдена");
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
        for (Entry entry : array){
            if (entry != null){
                System.out.println(entry.key.PrintCompanyKey() + ": " + entry.value.NameOfCompany);
                Entry nextElement = entry.next;
                while (nextElement != null){
                    System.out.println("-> " + nextElement.key.PrintCompanyKey() + ": " + nextElement.value.NameOfCompany);
                    nextElement = nextElement.next;
                }
            }
        }
    }
}