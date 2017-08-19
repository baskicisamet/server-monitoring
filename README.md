# server-monitoring



Bir sisteme bağlı olan serverların,donanım hareketlerini tek bir ekran üzerinden izlenip kolay bir şekilde kontrol edilmesini , ve beklenmedik durumlarda yöneticinin bilgi durum hakkından bilgi edinmesini sağlar.


Proje bileşenleri : 
	* Netdata    :  donanım izleme işini netdata üstleniyor
	* JSP           :  jstl tagları sade bir şekilede gelen veri jsp ile ekrana yansıtılıyor.
	* Servlet     :  controller olarak servlet kullanılmıştır. Server bilgileri alınıp jsp’ye aktarılıyor.
	* Apache Tomcat  : basit ve hızlı bir yapısı olduğu için container olarak tomcat kullanıldı.
	* GSON :  gelen json verileri modellere basit bir şekilde geçirmemizi sağladığı için Gson 		     tercih edilmişir.
