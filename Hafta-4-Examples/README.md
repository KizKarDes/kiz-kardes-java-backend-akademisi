## TaskManager
Bu örnekte, bir görev yönetim sistemi simüle edeceğiz. Kod, `tasks.txt` isimli bir dosya oluşturacak, bu dosyaya görevler ekleyecek, mevcut görevleri okuyacak ve yeni görevler eklemeye devam edecek.

### Örneğimizin Adı: Task Management System

**1. Dosya Yönetimi (File Sınıfı Kullanımı):**

- `FILE_NAME` sabitiyle belirtilen `tasks.txt` dosyası, görevlerin saklanacağı dosyadır.
- `File` sınıfı kullanılarak dosyanın varlığı kontrol ediliyor. Eğer dosya yoksa, kullanıcıya bilgilendirme yapılıyor ve yeni görevler eklenerek dosya oluşturuluyor.

**2. BufferedReader ve BufferedWriter Kullanımı:**

- BufferedWriter: `addTask` metodu, kullanıcıdan alınan görevleri BufferedWriter kullanarak `tasks.txt` dosyasına ekler. `FileWriter` ile dosya oluşturulur ya da var olan dosya üzerinde ekleme yapılır (`true` parametresi ile).
- BufferedReader: `readTasksFromFile` metodu, BufferedReader kullanarak `tasks.txt` dosyasını satır satır okur ve her satırı bir listeye ekler.

**3. Kapsamlı Kullanım Senaryosu:**

- Kullanıcı menü üzerinden görevleri listeleyebilir, yeni görevler ekleyebilir veya çıkış yapabilir.
- Görevler eklenirken, yazma işlemi için tampon kullanılır, böylece yazma işlemleri hızlı ve etkili bir şekilde gerçekleştirilir.
- Görevler okunduğunda, tampon kullanımı sayesinde okuma işlemleri optimize edilmiştir.

## NotePad

Bu uygulama, `notes.txt` adında bir dosya oluşturacak, notları bu dosyada saklayacak, notları listeleyecek, belirli bir notu silecek ve tüm notları temizleme işlevlerine sahip olacak.

### Örneğimizin Adı: NotePad Not Defteri App


**1.  Dosya Yönetimi (File Sınıfı Kullanımı):**

- `FILE_NAME` sabiti ile belirtilen `notes.txt` dosyası, notların saklanacağı dosyadır.
- Dosyanın varlığı `readNotesFromFile` metodunda kontrol edilir. Eğer dosya mevcut değilse, kullanıcıya bilgi verilir ve yeni dosya oluşturulur.

**2. BufferedReader ve BufferedWriter Kullanımı:**

- BufferedWriter: `addNote`, `clearAllNotes`, ve `writeNotesToFile` metodları BufferedWriter kullanarak notları ekler, temizler veya dosyaya yazar. Bu işlemler tampon bellekte yapılarak performans artırılır.
- BufferedReader: `readNotesFromFile` metodu, BufferedReader kullanarak notları okur ve her satırı bir listeye ekler.

**3. Kapsamlı Kullanım Senaryosu:**

- Kullanıcı menü üzerinden mevcut notları listeleyebilir, yeni not ekleyebilir, belirli bir notu silebilir veya tüm notları temizleyebilir.
- Dosya yönetimi işlemleri, performans ve verimlilik sağlamak için tamponlama yöntemleri ile gerçekleştirilir.
