package com.cj.mpgen.util.enc;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;


/**
 * @author Exrickx
 */
@Slf4j
public class JasyptUtil {

    /**
     * Jasypt生成加密结果
     * @param password 配置文件中设定的加密密码 jasypt.encryptor.password
     * @param value 待加密值
     * @return
     */
    public static String encyptPwd(String password,String value){
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setConfig(cryptor(password));
        String result = encryptor.encrypt(value);
        return result;
    }

    /**
     * 解密
     * @param password 配置文件中设定的加密密码 jasypt.encryptor.password
     * @param value 待解密密文
     * @return
     */
    public static String decyptPwd(String password,String value){
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setConfig(cryptor(password));
        String result = encryptor.decrypt(value);
        return result;
    }

    public static SimpleStringPBEConfig cryptor(String password){
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(password);
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        return config;
    }

    public static void main(String[] args){

        //加密
//        System.out.println(encyptPwd("root","admin"));
//        System.out.println(encyptPwd("root","47.94.45.159"));
//        System.out.println(encyptPwd("root","Ranx1985"));
//        System.out.println(encyptPwd("root","59.110.164.54"));
//        System.out.println(encyptPwd("root","118.123.16.211"));
//        System.out.println(encyptPwd("root","127.0.0.1"));
//        System.out.println(encyptPwd("root","rootpass"));
//        System.out.println(encyptPwd("root","59.110.164.54:8070"));
//        System.out.println(encyptPwd("root","jdbc:mysql://118.123.16.211:3306/ujie?characterEncoding=UTF-8&useSSL=false&allowMultiQueries=true\n"));
//        System.out.println(encyptPwd("config","https://github.com/xdfh/config.git"));
//        System.out.println(encyptPwd("PBEWithMD5AndDES","123456"));
//        System.out.println(encyptPwd("PBEWithMD5AndDES","139.224.195.76"));
//        System.out.println(encyptPwd("PBEWithMD5AndDES","47.103.64.182"));
//        System.out.println(encyptPwd("PBEWithMD5AndDES","192.168.5.133"));
//        System.out.println(encyptPwd("PBEWithMD5AndDES","root"));
//        System.out.println(encyptPwd("PBEWithMD5AndDES","rootpass"));
//        System.out.println(encyptPwd("PBEWithMD5AndDES","63306"));
//        System.out.println(encyptPwd("PBEWithMD5AndDES","16379"));
//        System.out.println(encyptPwd("PBEWithMD5AndDES","5672"));
//        System.out.println(encyptPwd("PBEWithMD5AndDES","admin"));
//        System.out.println(encyptPwd("root","emp22"));
//        System.out.println(encyptPwd("root","Empsun=="));


//        System.out.println(encyptPwd("root","MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDYrESiaTWA5MfWEnBkOBaJjD9oBtGxoH/04zhoy+kI4NdRxDpRTE8gfiSuTKKQPHiZ5SV+u/fjvHJV37B5l0RIp4IN2mp4pN3gyfrb9JRZPgB4F9x+S4PTQ/8o94UBf0tlEyCTRzAOJQmYJ10J8y8hsWkKn8IbtGMB9iTrwyx20Kc3O84okSu9nbi/inU0bGV9NptRcsgMF5VXpGNDDifOHGCvQxFeRPz8fx6PGBoMCsAaWvwkJL9iNLqCvkEwSdHiIblxjNp82enOjGHTYqlLVGQjlj7p54jwbioH096kCFbiZGK+qvmzPPvJhPRPH6os5Vx0soNVmgbk1y2M6EMxAgMBAAECggEAKUbgKGSMmcp7u29109HPkVKTfbjW19Twq3Fh/Kzj7xoOSvhr97Lm3BTL3hyhV4L9oqvBsdwTRGJREcT0dKV5j7HBl+wFHoih8EHqNV7pp/qk0jwReEngii3I/T/yKa/baBz1trj4EanCoybUlaGrV+rZTPnUW7zIo8YFkJh07wlE3hWjTj+P/2kxPVwodbzKLZxb9reWCNBkapk3ykBfdL+fXM9dBtZkQDSSynm2QC7wITmrw1/nJABs2aTBKWyWIBIrl9FxIOeC5uJ7GAg5JzqXbxv43Cp8B79iumchEdnvcZ9MCE6+gwzCNWpIIv6lEWQF8oYNwqTWRD4PGmlEsQKBgQD+2zqq0XthNIHLlGvpvn5F70tFAndJblBtf74CmL+iMbcebWIeV6WvE6zRVRAWYq5o+zvtzWoEfemiascKvNdMVYnlzAi+bC3uzzyzy0Vi3pHvRjanHQbcRY7YGo3DijdQpRZ5kUs/sEDWW9rIbcxjOryOIjhyuFru245WbWXCvQKBgQDZpSzOCxkGnVfeWlARLGAB8ACWsQDu8+33VGQQF9GIJqgPf+Pnw8TI8gLbTVYZ+QRo/4xdxc9JHRmZWm3geLOiDsAQTKX7/SNnO6YBMBeCbru3p4Ud9Yf88DCcbKbBQAQ34+OZ/x7AT5Bo4o0qpOxXvQz0KZcyNP0h5bkOENdjhQKBgQDzthN5LE/PGdYRJwK3CNpZ6EZTXNNTnjE9NQ4wD4AaC26woytUFr6zGJ6Ho895iK5+Z9ncQzXhy8Ky9WcXxpQgRCBVZvLpniuilfzXdkgJDwwBA2TaE/DujXnXADWWy0KwVN6ULDQIWHT4R+iFCDKOpamQRfszAUa76atIzN6mBQKBgDugsDTG/5U7WE53ycXatXbybQbb+Zh9xe1j9oIeNG6rwJF2hVcC4I/5FeVFO9ijy5yEns02G4M5cMD98Gp2RyiYB/CvPy5ZfPCUe/eJWHeIpO88+xBpK1eV6ouAjPMW+dDiI4IWTjN72OGTZ/+N7Z5gEgN2vZCoyc0Wpet/m7MNAoGBAI6GKSyo6mFJxUpXCYmYaXmh9FzeA5ad9ZaGJAn4Aij7nG3WChVv6S/8KtGw7/yZc8lT/gEAAfqR3/OMwmIETmEdwEHUpZul9UrcChgMV4wrFEF51r+jdHNDZnPmKAtpe9jkCaWkaaZ6/jFHmrCaqaD9/CQeDKLGrkXPs8TTqJ0X"));
//        System.out.println(encyptPwd("root","MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAshZsMB9rL+lD6TPB+lEwWOfdqgb/cjoNxrA4OXSf6aya58EMu10K5yGbxqSnibI3UzoHLax3pMCsiNKvE0E/1TgUdE0IA7TVG541w96KBH06To2YuCxtBSKVVZfdsRSScIb511Sn7ncVXd8AQ6qa/Pq0u9X00hmTIi9TNjAaEGzaygJBWSHYpj2DpHw9ngI1qK3ACwSeUfzM1QUyNejjVKPSSYaKCjtwpOBr4XcCxf9jp9sWjUKy4knydSJ9y6cSNi14S2DddRbzpxxqSJYuEMXWVWLfI9z/CMoW/x4LwlYawV8wNbegqf2nrKw4eyt+3QnYfh031pQFjwpXw+jVhQIDAQAB"));
//

        System.out.println(encyptPwd("root","MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQClkRkY48QUmZQ3recGWOClsm0Owk63Ugi8Rs8ZtP7X7jIJ4AD0vz/599e9/EN6rRE73Ea0Vh8wnvmN7w8OYy2O5tfFiPKwEUG8pv9nLR5v2kNtP1sCgpO4vRe4XbbIIEt2u9xip3rvdKw9oqnDy03BCifoyll1nyFdgxH88yt8JJ5c2eC4bfAlYpfk90P4gHx85vsvZZV//yANTtN4+kyMvKOQJV5N+rVW5vlU4t6Eghok/qIzC59Q8dvrqVcK8QBGDP+pwYDt97ehdVM+ufueWe9tnB3jtzNs1D0DbX2xSp5ipWVx4omM5tz+/NJ1csHbdZo1spR2XJ/4VzKBmZK7AgMBAAECggEARexXqxlWUFTkMfex4A5dId2PDXKmh+mPYuSMxpCYKF2iqGUAQl0bCdjQNp55aS/6XUuUWMkedwxM3NKfizX7oaSAcB58UDuZhbEJoGt/tUF6xILDTvYSqSzC/cwmS7LH7Cc+1jNhSgv+SjGOfPA5sFM3s6rxySkhkDqwuCGCtfSXXlEaWtv7sLw4+4hPuykBRejuloHjd/DpRuzW0m3w7RFSKroO7XCUaMlXK91z0x7tdmYCyRxcgQNNUqQu7WutlODV6adglqQP9SUpGhN+KDNli0bOTWWnJJKwiNVwwkH+YqYoo8RBTlkf6NY3pqrc4rumRvH3ktItKBTdhdLXwQKBgQD+M6Bm93QGzdaDSqJhbp6JgoxbCY07nQhu3ATSdKBUhjC24spbJiL5xYJ2xQM5nwJ/wOGBGgtDGtjsXM0c+49lUZ/EDLhvb8iMY7JWABvkDTnpoYIs8wyagPF6aJEswRuOB1KIwJ0tSYg12J5R5EFokCXekxVvi1jwDC/6zWtl0QKBgQCmvPLhGuAjWLHk15YiwGjDBYG1S/dMmzRkRwrMEA3MV2aoQD/llM2Y0LJVVzUEb4bi1lP8FyQVklBfXPl6EYDEElpzGq71zPHSkSksIHDqrIs988u3EzjO9AuOuJ/1ofcn2AREzWrUDbOmod0VI3SKD1DoUmu65WlkUSLRkUn2ywKBgARr+XpRC5+irPyTq8duGSvjLXXX8LD8xkzHXv4aMT/HJcnIoCR9wVX+7YoLW0cBURXP0Rxhy5hbOzLBWoAKkC/+/3x1jC/EDgUDJvMABXwuDrfVq2IEyE9XttuePgg9Q7FwxyrBzvoesVPedMKP6eNbvozkmhbaoa1rSNpgAGJBAoGAPH2QH9qANlKXN05/SVxEpXv58qv8q+4is76STDYGy3tp4uBsTf4OGMKd8BgTQ+iyJtla3roGfUz3m6E/YOm4rWl7JwcnMkWH9bx0E24xiPHQEknAPkra8TnYd47DeXmpEOttoQhlGUlfQ7S1YFXckbm8wIwmSUexVJOa7iyniMECgYEArz4+ZbKr0fd+GiZKYGTpCGyHWgAUkYdofQpRP17VaQXq5GsRKpX1H/ccb9IeqHYkC8QGZxis85yTCoN3Yoiml+j6PIHy8AXY+GMG0/aG4fXfb4G4ZOumNtpGXinbi4Tz5AWZzUIb2845XvbJTcZBr8DW1qLjBqYgQIU8BFKp078="));
        System.out.println(encyptPwd("root","MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlBH6nHfv3hLbNDNC5smBJVVuatJ0siCFM8wggv5b8PlkkQiit0hWkWE6mfRp06Cdca0f9YAiID9txM8nQZCz2FYbAb8VOrQPrrZ8y5N3jxpC4upLfc78Iu13IdW9KdDNI+ctZwdVgpXplG41zJqa646hUUJPHd+Nu54nnqX7SaYp6z05Wqb0nD+t50zZWvdVIPGjinhc89wZQ2EUCepTBxLdJaek8dUyDKW65ZBwR8zxYBHQlcpDMWgKCg47GLphtBZ4UUQ3/hz+wyv9ZzKMnrcPum588n2rYrLdy4C+B8veot6kdDAFI8GN4KYsZ6HseVAfpZI9xdnEUlDKb41wJwIDAQAB"));




        //解密
        System.out.println(decyptPwd("root","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"));
        System.out.println(decyptPwd("root","xHQhuT+yJ8Qakkt8qa2tg5njpXm6wP+LPjDWQH7V7KaCSQ3qpcea0A+r34G04H1xkCUQE+cs8pJy5g4b6scSl2Jv/FE2wUwH/6jd29+LVSFbWNh1kJSQfVJfFbK8D7GOfOOMEdX1aA45NS8y9N/spk6kDDErp9nfB6lkoXb4MSWMFySti9Ic1bRVt2XBtQq8ErLRIUVpjYmablL2zHb+AyYvY11zpP0w9Sx+SRLF23bPwBb4VinFzRjxH2gH+Uq5kxvFiMcHV4cOdjfxVKuGilIWqN+FnoRiFsdLv8tSG/sazzt2UYUtvLsFmL1GN/NQ3+7r/1vAx3O2w2sL4uD+uIMi7KPdgSMgmQ1TenWaCHkK8HnRGOSN3ODNx9B3vOdCAwQC+p3qcXdZcUfjmkaQA77AwgDsAe4S404ozvZ4HWbqf2sFQdEM5GnzKhSq8jIrXqYr6rS7C8E4QTnRvQ5evcpvS6OxZByQEyfyhI3nYdNS1rJ2dUJEe4EPSzZOleXfz9xfjlIsXKTFA95Hov2CE0Cpyc3UEzGz" ));
//        System.out.println(decyptPwd("root","emp22"));
//        System.out.println(decyptPwd("PBEWithMD5AndDES","GtEHnggEP84drOT5aA75pZoVNhYgOMdU"));
//        System.out.println(decyptPwd("zkhyhygl","E+AkkCtpQ7kfA7i5/aeHWw=="));
    }
}
