# JBossのUndertowやServlet 3.1でWebFluxが使えるかなどを調べる

## ビルド手順

```
mvn clean package
```

## デプロイ

warファイル「spring-web-flux-trial1-0.0.1-SNAPSHOT.war」をJBoss EAP/WildFlyにデプロイする。

## 動作確認

```
curl -i http://localhost:8080/spring-web-flux-trial1-0.0.1-SNAPSHOT/fluxtest1/aa
```

Result is aa!

```
curl -i curl -i http://localhost:8080/spring-web-flux-trial1-0.0.1-SNAPSHOT/fluxtest1/aiueo
```

*aiueo*kakikukeko*sashisuseso*tatitsuteto

## 参考サイト

https://stackoverflow.com/questions/54034108/request-forwarding-with-servlethttphandleradapter-spring-web-flux-in-servlet-3-1

https://github.com/spring-projects/spring-framework/issues/19106

