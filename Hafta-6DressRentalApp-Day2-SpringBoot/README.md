
# Dress Rental App - Spring Boot Edition

Dress Rental App, Java Spring Boot ile geliştirilmiş bir backend uygulamasıdır. Bu proje, web servisleri oluşturma, RESTful API geliştirme, Spring Boot ile veritabanı işlemleri ve hata yönetimi gibi konuları pratik etmek için hazırlanmıştır.


## Özellikler

- **Spring Boot:** RESTful API geliştirmek için kullanılmıştır.
- **Veritabanı Entegrasyonu:** Spring Data JPA kullanılarak CRUD işlemleri gösterilmiştir.
- **Hata Yönetimi:** Uygulama genelinde etkili hata yönetimi ve istisna yakalama mekanizmaları uygulanmıştır.
- **Transaction Yönetimi:** Veritabanı işlemlerinde transaction yönetimi sağlanmıştır.

## Başlangıç

### Gereksinimler

Projeyi çalıştırmak için sisteminizde aşağıdaki yazılımların kurulu olması gerekmektedir:

- Java 17 veya üstü
- Maven 3.8 veya üstü
- Docker ve Docker Compose (opsiyonel)
- IntelliJ IDEA veya başka bir IDE
- MSSQL veya uyumlu başka bir SQL veritabanı

### Kurulum

1. **Projeyi klonlayın:**

   ```bash
   git clone https://github.com/JavaBackendGelistirmeAkademisi/Hafta-6-DressRentalApp-Day2-SpringBoot.git
   cd Hafta-6-DressRentalApp-Day2-SpringBoot
   ```

2. **Veritabanını yapılandırın:**

   - `dressrental` adında bir veritabanı oluşturun (Docker ile çalıştırılacaksa bu adım gerekmez).
   - `src/main/resources` klasöründeki `application.properties` dosyasını veritabanı bilgilerinize göre güncelleyin.

3. **Projeyi Maven ile derleyin:**

   ```bash
   mvn clean install
   ```

4. **Spring Boot uygulamasını çalıştırın:**

   ```bash
   mvn spring-boot:run
   ```

   Uygulama başlatıldıktan sonra API'leri kullanmaya başlayabilirsiniz.

5. **Docker ile çalıştırma (opsiyonel):**

   Uygulamayı Docker ile çalıştırmak için, projenin kök dizininde bulunan `docker-compose.yml` dosyasını kullanabilirsiniz:

   ```bash
   docker-compose up --build
   ```

## API Endpoints

Dress Rental App uygulaması şu endpointleri sunar:

- `GET /dresses`: Tüm mevcut elbiselerin listesini getirir.
- `POST /dresses`: Envantere yeni bir elbise ekler.
- `PUT /dresses/{id}`: Mevcut bir elbisenin detaylarını günceller. Kiralama işlemini burada yapıyoruz

## Kullanılan Teknolojiler

- **Java 17:** Backend mantığı için kullanılan ana programlama dili.
- **Spring Boot:** RESTful servislerin hızlı geliştirilmesi için kullanıldı.
- **Spring Data JPA:** Veritabanı işlemlerini basitleştiren bir Spring modülü.
- **Maven:** Proje bağımlılık yönetimi ve derleme işlemleri.
- **Docker & Docker Compose:** Uygulamayı ve MSSQL veritabanını kapsayıcı olarak çalıştırmak için kullanılır.
- **MSSQL:** Veritabanı yönetim sistemi olarak kullanılmıştır.

## Katkıda Bulunanlar

Bu proje, Java Backend Geliştirme Akademisi tarafından geliştirilmiştir.

## Lisans

Bu proje MIT Lisansı altında lisanslanmıştır. Daha fazla bilgi için `LICENSE` dosyasına bakın.
