# README - Website hỗ trợ học Tiếng Anh
## Danh sách thành viên:
###  **Trần Thanh Tuấn** - B20DCCN620
###  **Bùi Nguyên Bình** - B20DCCN092
###  **Nguyễn Hoàng Việt** - B20DCCN728
## Giới thiệu

Website này là một công cụ đa năng và tiện ích cho những người muốn tạo ra nội dung tiếng Anh chất lượng cao một cách nhanh chóng và hiệu quả. Với khả năng hỗ trợ tạo nội dung và dịch tự động từ các chủ đề mà người dùng đưa ra, ứng dụng này không chỉ giúp tiết kiệm thời gian mà còn mang lại sự linh hoạt và tiện lợi.

Một trong những tính năng nổi bật của ứng dụng là khả năng tạo nội dung tự động. Người dùng chỉ cần cung cấp các chủ đề, từ khóa hoặc ý tưởng cơ bản, và sau đó ứng dụng sẽ tự động tạo ra các đoạn văn bản phù hợp. Từ việc tạo ra nội dung blog, bài viết trên mạng xã hội cho đến bài thuyết trình hoặc bài luận, mọi thứ đều có thể được tạo ra một cách nhanh chóng và dễ dàng.


## Kiến trúc hệ thống

Hệ thống bao gồm các dịch vụ chính sau:

### English Service

-   Chức năng: Xử lý các yêu cầu liên quan đến ngôn ngữ tiếng Anh, bao gồm kiểm tra chính tả, ngữ pháp, và cung cấp các câu gợi ý.
-   Công nghệ: Spring Boot

### Textgeneration Service

-   Chức năng: Tạo văn bản tự động dựa trên các đoạn văn bản nhập vào.
-   Công nghệ: Spring Boot

### Translate Service

-   Chức năng: Dịch văn bản từ tiếng Anh sang các ngôn ngữ khác (tiếng việt) bằng cách sử dụng API của Google Translate.
-   Công nghệ: Spring Boot
-   Dịch vụ bên thứ 3: API Google Translate

### Voice Service

-   Chức năng: Chuyển đổi văn bản thành giọng nói sử dụng API Text to Speech.
-   Công nghệ: Spring Boot
-   Dịch vụ bên thứ 3: API Text to Speech

### EurekaServer

-   Chức năng: Đăng ký và quản lý các dịch vụ microservices trong hệ thống.
-   Công nghệ: Spring Boot, Eureka

### ApiGateway

-   Chức năng: Cung cấp một điểm truy cập duy nhất cho tất cả các dịch vụ, giúp điều phối các yêu cầu từ người dùng đến các dịch vụ phù hợp.
-   Công nghệ: Spring Boot, API Gateway

## Công nghệ sử dụng

-   **Backend**: Spring Boot Microservice
-   **Frontend**: HTML, CSS, JavaScript
-   **Database**: MySQL

## Dịch vụ bên thứ 3 tích hợp

-   **API Google Translate**: Sử dụng để dịch văn bản từ tiếng Anh sang các ngôn ngữ khác.
-   **API Text to Speech**: Sử dụng để chuyển đổi văn bản thành giọng nói.
-   **API Gemini**: Sử dụng cho dịch vụ Textgeneration.
-   **Swagger OpenAPI**: Dùng để tự động tạo tài liệu API và cung cấp giao diện thử nghiệm API.
-   **Eureka**: Sử dụng cho việc đăng ký và phát hiện các dịch vụ trong hệ thống.
-   **API Gateway**: Để điều phối và quản lý lưu lượng truy cập vào các dịch vụ khác nhau.

## Hướng dẫn cài đặt và chạy ứng dụng

1. **Cài đặt môi trường**:

    - Cài đặt JDK (phiên bản 20)
    - Cài đặt MySQL
    - Cài đặt Maven

2. **Cấu hình Database**:

    - Tạo một database MySQL mới.
    - Cập nhật thông tin kết nối database trong file `application.properties` của từng dịch vụ.
    - Tên database : englishservice.

3. **Chạy lần lượt các service**

Chúng tôi chào đón mọi sự đóng góp từ cộng đồng. Vui lòng tạo các pull request hoặc báo lỗi trong repository này.
