// Program java untuk mengurutkan angka acak menggunakan insertion sort
// Dibuat oleh Dimas Angkasa Nurindra

// Import module yang dibutuhkan
import java.util.Scanner;
import java.util.Random;

public class App {
  public static void main(String[] args) {
    int menu = 0; // menyimpan menu yang akan dipilih
    int length = 0; // menyimpan panjang array yang akan dibuat
    boolean restart = true; // Untuk restart program

    int[] arr; // Deklarasi array

    // Melakukan looping agar panjang array yang dimasukan lebih dari 1
    do {
      // Memanggil metoh inputInt yang sudah dibuat dibawah untuk print string
      // Pada method inputInt juga mengembalikan nilai berupa integer yang dimasukan
      // ke variabel length
      length = inputInt("\nJumlah Angka / Panjang Array");
    } while (length < 1);

    // Menggunakan method randomize untuk membuat array acak dengan panjang array
    // sesuai length
    arr = randomize(length);

    // Terdapat looping agar program dapat mengulang dari awal
    do {
      // mencetak pilihan menu
      System.out.println("\n--------Pilih Menu--------");
      System.out.println("1. Lihat Angka");
      System.out.println("2. Acak Angka");
      System.out.println("3. Urutkan dari yang terkecil");
      System.out.println("4. Urutkan dari yang terbesar");
      System.out.println("5. Keluar");

      // Membaca pilihan menu yang dipilih user
      menu = inputInt("Pilihan");

      // Menggunakan switch untuk menentukan program mana yang jalan sesuai dengan
      // pilihan menu
      switch (menu) {
        case 1:
          // Jika pilihan menunya 1, maka akan menampilkan isi array
          System.out.println("\n--------Lihat Angka--------\n");
          display(arr);
          break;
        case 2:
          // Jika pilihan menunya 2, maka akan mengacak angka lagi
          System.out.println("\n--------Acak Angka--------\n");
          arr = randomize(length);
          System.out.println("Berhasil diacak!");
          break;
        case 3:
          // Jika pilihan menunya 3, maka akan mengurutkan array dari yang terkecil
          // (ex: 1-10)
          System.out.println("\n--------Urutkan dari yang terkecil--------\n");
          // Memasukan array kedalam method insertionSortAsc
          insertionSortAsc(arr);
          System.out.println("Berhasil diurutkan!");
          // Setelah di urutkan, akan ditampilkan hasilnya
          display(arr);
          break;
        case 4:
          // Jika pilihan menunya 4, maka akan mengurutkan array dari yang terbesar
          // (ex: 10-1)
          System.out.println("\n--------Urutkan dari yang terbesar--------\n");
          // Memasukan array kedalam method insertionSortDesc
          insertionSortDesc(arr);
          System.out.println("Berhasil diurutkan!");
          // Setelah di urutkan, akan ditampilkan hasilnya
          display(arr);
          break;
        case 5:
          // Jika pilihan menunya 5, maka akan mengubah variable restart menjadi false
          // dimana akan membuat program menjadi tidak mengulang dari awal lagi
          restart = false;
          break;
        default:
          // Default dibuat langsung break agar langsung menampilkan menulagi
          break;
      }
    } while (restart); // Jika variable restart = true, maka akan menampilkan menu dari awal lagi

    System.out.println("\n--------Selesai--------");
  }

  // Method untuk membuat array yang diisi dengan angka random
  public static int[] randomize(int length) {
    // Inisialisasi
    Random random = new Random();
    // Deklarasi array yang isinya bertipe integer dan panjangnya sesuai dengan
    // length yang dimasukan
    int[] newArr = new int[length];

    // Perulangan untuk setiap bagian array
    for (int i = 0; i < length; i++) {
      // Kemudian memasukan angka acak pada array
      newArr[i] = random.nextInt(length);
    }

    return newArr;
  }

  // Nethod untuk mengurutkan angka dalam array dari yang terkecil
  public static void insertionSortAsc(int array[]) {
    // Mendapatkan panjang array
    int n = array.length;

    // Melakukan perulangan sebanyak panjang array
    for (int j = 1; j < n; j++) {
      // Memasukan isi array ke [j] pada variable key
      int key = array[j];
      // mendapatkan nilai dibawah j
      int i = j - 1;
      // Kemudian melakukan pengecekan jika isi array ke [i] lebih besar dari key
      while ((i > -1) && (array[i] > key)) {
        // Maka array ke [i] akan dimajukan 1 kali
        array[i + 1] = array[i];
        // Akan diulang sampai array ke [i] lebih kecil dari key
        i--;
      }
      // array ke [i+1] akan diisi nilai key
      array[i + 1] = key;
    }
  }

  // Nethod untuk mengurutkan angka dalam array dari yang terbesar
  public static void insertionSortDesc(int array[]) {
    // Mendapatkan panjang array
    int n = array.length;

    // Melakukan perulangan sebanyak panjang array
    for (int j = 1; j < n; j++) {
      // Memasukan isi array ke [j] pada variable key
      int key = array[j];
      // mendapatkan nilai dibawah j
      int i = j - 1;
      // Kemudian melakukan pengecekan jika isi array ke [i] lebih besar dari key
      while ((i > -1) && (array[i] < key)) {
        // Maka array ke [i] akan dimajukan 1 kali
        array[i + 1] = array[i];
        // Akan diulang sampai array ke [i] lebih kecil dari key
        i--;
      }
      // array ke [i+1] akan diisi nilai key
      array[i + 1] = key;
    }
  }

  // Method untuk menampilkan isi array
  public static void display(int[] arr) {

    // Melakukan looping sesuai dengan panjang array
    for (int i = 0; i < arr.length; i++) {
      // Menampilkan isi array ke [i]
      System.out.print(arr[i]);
      // Kondisi jika bukan sisi array yang terakhir
      if (i < arr.length - 1) {
        // Maka akan ditambahkan koma
        System.out.print(", ");
      }
    }
    System.out.println("");
  }

  // Method input integer
  public static int inputInt(String message) {
    // Deklarasi scanner
    Scanner input = new Scanner(System.in);
    // Menampilkan pesan
    System.out.print(message + " : ");
    // Membaca yang diinput user kemudian langsung dikembalikan
    return input.nextInt();
  }
}
