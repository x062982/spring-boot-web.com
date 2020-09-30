package com.shanezhou.springboot.test;


//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jws;
//import io.jsonwebtoken.Jwts;
//import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import javax.swing.*;
import java.security.*;
import java.security.cert.CertificateException;
        import java.security.spec.InvalidKeySpecException;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author ZhouWX
 * @createDate 2020/6/30
 */
public class Test01 {

    public static void main(String[] args) throws NoSuchFieldException, NoSuchAlgorithmException, InvalidKeySpecException, CertificateException, NoSuchProviderException {

        //String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1OTc1OTkxNzksInVzZXJfbmFtZSI6InNoYW5lIiwiYXV0aG9yaXRpZXMiOlsiVVNFUiJdLCJqdGkiOiJmOWNlNjQ0Yy03NDE4LTQ2ZWMtOTlhYy1lMDBkZGY1ZmFhN2MiLCJjbGllbnRfaWQiOiJpZC1zaGFuZSIsInNjb3BlIjpbImRlZmF1bHQtc2NvcGUiXX0.Y4nBYsaI2WblzatwvB1iVy4Ao0UTsSdV3PyjGg95bYdrtF5ucawrN71FuVQY6VEQYwhnfBWaoQ9eeS7vkKXA-429M8oaOsSkAVAEhfBnv5nQvOwNkzDUj6aSdZjWte3BLFFqynjMySqrCfRS9rf0hCXXXMtJIPolJYo5j061n7wpPsbRSrsG4ioUAg1F3ZBPicrv1Dy0tUrxJ9NbGXNSGQDaxh0LQMqwTclPSw3CJI-HljjWW2h2d59wlz5tVKi04IX_aeF5Fv7NrUleiTb9lzAxrljNKO87V3zicO6bOXlcukeJ1ZdFqUnwkNTXc4MlcZVW8FB6NVqlqhCd1SQ4FA";
        ////String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1OTcyMzY0MzYsInVzZXJfbmFtZSI6ImxpeGoiLCJhdXRob3JpdGllcyI6WyJVU0VSIl0sImp0aSI6IjRjZDExM2VjLTQ1NDEtNDRjMC1hNDhmLWIyM2YwYjdjZDY5ZSIsImNsaWVudF9pZCI6InNtaXRoeS1wYyIsInNjb3BlIjpbImRlZmF1bHQtc2NvcGUiXX0.Xb2fMFfwQiMaXpuWGaAScDLFdvbZ244rlcNM8Tz9cQYj_12JEc_dcDoPbxWWEM5PxegxURs6JIVpKh3gMqlX_7-7AUnjDS1zCojZLLFLslb4HZS_QZM77P7THIPZPITodqBWLcWWLfzD736pUJlbZ_2BHPSjsmuZLwaUxsEzBiFmtrLlSuhac_cNq-FamddQ_FqQiDnhfLlNRHcu2hb5ZA4kBGRjdDBDWP4d1jlaKoRblJPGwYwqsYWq7oPYma_sG5Zm26ramkGmhh3povSBwaqLtO_XJqgxL1iL2TYuSxOWAwPBkccjUSKsEbjw9m-SKAfG7CKb1rpUYRfRyvM0Yw";
        //
        //try {
        //
        //    //Resource resourcePublic = new ClassPathResource("public-key.txt");
        //    KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(
        //            new ClassPathResource("rsa-key.jks"),
        //            "123456".toCharArray());
        //    KeyPair keyPair = keyStoreKeyFactory.getKeyPair("test", "123456".toCharArray());
        //    RSAPublicKey publicKey = (RSAPublicKey)keyPair.getPublic();
        //
        //    //File file = new File("C:\\Users\\shanezhou\\Desktop\\public-key.cer");
        //    //InputStream is = new FileInputStream(file);
        //    //Resource resourcePrivate = new ClassPathResource("privateKey.txt");
        //    //byte[] bytesPublic = new byte[0];
        //    //byte[] bytesPrivate = new byte[0];
        //    ////String privateKey = "";
        //    ////String publicKey = "";
        //    //
        //    //bytesPublic = IOUtils.toByteArray(is);
        //    //bytesPrivate = IOUtils.toByteArray(resourcePrivate.getInputStream());
        //
        //    //Map<String, Object> map = RSAUtil.init();
        //
        //    //RSAPublicKey publicKey = map.get(RSAUtil.KEY_PUBLIC);
        //    //RSAPrivateKey privateKey = (RSAPrivateKey)map.get(RSAUtil.KEY_PRIVATE);
        //    //X509EncodedKeySpec spec = new X509EncodedKeySpec((byte[])map.get(RSAUtil.KEY_PUBLIC));
        //
        //    //X509EncodedKeySpec spec = new X509EncodedKeySpec(bytesPublic);
        //    //X509EncodedKeySpec spec2 = new X509EncodedKeySpec(bytesPrivate);
        //    //KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        //    ////PrivateKey privateKey = keyFactory.generatePrivate(spec2);
        //    //RSAPublicKey publicKey = (RSAPublicKey)keyFactory.generatePublic(spec);
        //
        //    //KeyPair pair = new JcaPEMKeyConverter()
        //    //        .getKeyPair((PEMKeyPair)new PEMParser
        //    //                (new FileReader("C:\\Users\\shanezhou\\Desktop\\rsa-key.jks"))
        //    //                .readObject());
        //    //RSAPublicKey publicKey = (RSAPublicKey)pair.getPublic();
        //
        //
        //    //CertificateFactory cf = CertificateFactory.getInstance("X509", "SUN");
        //    //X509Certificate certificate = (X509Certificate)cf.generateCertificate
        //    //        (is);
        //    //is.close();
        //    //
        //    //RSAPublicKey publicKey = (RSAPublicKey)certificate.getPublicKey();
        //
        //
        //    Jws<Claims> claimsJws = Jwts.parser().setSigningKey(publicKey).parseClaimsJws(token);
        //    Claims body = claimsJws.getBody();
        //    body.forEach((k, v) -> {
        //        System.out.println(k + " : \t" + v);
        //    });
        //
        //    //JWTVerifier verifier = JWT.require(
        //    //		Algorithm.RSA256(publicKey, privateKey))
        //    //		.build();
        //
        //    //DecodedJWT verify = verifier.verify(token);
        //    //
        //    //verify.getClaims().forEach((k, v) -> {
        //    //	System.out.println(k + " : \t" + v);
        //    //});
        //
        //} catch (Exception e) {
        //    e.printStackTrace();
        //    //} catch (CertificateException e) {
        //    //	e.printStackTrace();
        //    //} catch (NoSuchProviderException e) {
        //    //	e.printStackTrace();
        //    //} catch (IOException e) {
        //    //	e.printStackTrace();
        ////} catch (CertificateException e) {
        ////    e.printStackTrace();
        ////} catch (NoSuchProviderException e) {
        ////    e.printStackTrace();
        //}
        //int[] arrs = {-1,-1,-1,-1,-1,1};
        //int a = method02(arrs);
        //System.out.println(a);

        //int[][] arr = new int[][]{{1,4}, {0, 4}};
        //arr = merge2(arr);
        //for (int[] a : arr) {
        //    System.out.print(Arrays.toString(a));
        //}

        //int[] arr = new int[]{1, 3, 5, 6};
        //int target = 5;
        //binaryMethod02(arr, target);

        //long now = System.currentTimeMillis();
        //LocalDateTime time = LocalDateTime.now();
        //long l1 = Timestamp.valueOf(time).getTime();
        //long l2 = time.atZone(ZoneOffset.systemDefault()).toInstant().toEpochMilli();
        //LocalDateTime l = LocalDateTime.ofInstant(
        //        Instant.ofEpochMilli(l1),
        //        ZoneId.systemDefault());

        //String num = "113";
        //String regx = "([1-9](\\d*))-([1-9](\\d*))";
        ////String[] numArr = num.split("-");
        ////int a = Integer.parseInt(numArr[1]);
        //System.out.println(num.matches(regx));

        //QueryWrapper<Object> wrapper = new QueryWrapper<>()
        //        .select("id").eq("name", "张三").orderByDesc("id");
        //String sqlSelect = wrapper.getSqlSelect();
        //
        //System.out.println(sqlSelect);
        //QueryWrapper<Object> wrapper1 = new QueryWrapper<>();

        //Random random = new Random();
        //
        //int[] arr1 = new int[100000];
        //int[] arr2 = new int[100000];
        //
        //for (int i = 0; i < 100000; i++) {
        //    arr1[i] = random.nextInt(100000);
        //    //arr2[i] = i + 100;
        //}
        ////Arrays.sort(arr1);
        ////Arrays.sort(arr2);
        //
        //System.out.println("数组1：" + Arrays.toString(arr1));
        ////System.out.println("数组2：" + Arrays.toString(arr2));
        //long start = System.currentTimeMillis();
        ////int[] arr = findDiffByBitSet(arr1, arr2);
        //quickSort(arr1, 0, arr1.length - 1);
        //long end = System.currentTimeMillis();
        //System.out.println("花费时间：" + (end - start));
        ////System.out.println("数组1：" + Arrays.toString(arr1));
        //
        //long start1 = System.currentTimeMillis();
        ////Integer[] arr3 = findDiffByMap(arr1, arr2);
        //BitSet bitSet = new BitSet(arr1.length);
        //for (int i = 0; i < arr1.length; i++) {
        //    bitSet.set(arr1[i]);
        //}
        //long end1 = System.currentTimeMillis();
        //System.out.println("花费时间：" + (end1 - start1));
        //System.out.println("数组1：" + bitSet.toString());
        //

        //System.out.println("arr:" + Arrays.toString(arr));
        //System.out.println("arr3:" + Arrays.toString(arr3));
        //int a = 0;
        //for (int i = 0; i < 1000; i++) {
        //    a++;
        //}
        //System.out.println(a);
        //for (int j = 0; j < 10; j++) {
        //    AtomicBoolean sign = new AtomicBoolean();
        //    try {
        //        TimeUnit.SECONDS.sleep(1);
        //    } catch (InterruptedException e) {
        //        e.printStackTrace();
        //    }
        //    int f = j;
        //
        //
        //    new Thread(() -> {
        //        while (!sign.get()) {
        //            for (int i = 0; i < 10000; i++) {
        //                if (i == 1000000000) {
        //                    return;
        //                }
        //            }
        //            try {
        //                TimeUnit.SECONDS.sleep(1);
        //            } catch (InterruptedException e) {
        //                e.printStackTrace();
        //            }
        //            System.out.println(Thread.currentThread().getName() + "\t" + f + "\t" + sign.get());
        //            sign.set(true);
        //        }
        //    }).start();
        //}
        //try {
        //
        //    TimeUnit.SECONDS.sleep(3);
        //
        //    System.out.println("----------");
        //    new Thread(()-> {
        //        System.out.println(Thread.currentThread().getName());
        //    }).start();
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}

        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("i:" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t"
                        + Thread.currentThread().getId() + "is running .......");
                //method01();
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t"
                        + Thread.currentThread().getId() + "is ending .......");
            }, "t1").start();
        }
        

    }

    public static void method01() {
        synchronized (String.class) {
            System.out.println("String lock");

            synchronized (Integer.class) {
                System.out.println("Integer lock");
            }
        }
    }

    public static void method02() {
        synchronized (Integer.class) {
            System.out.println("Integer lock");

            synchronized (String.class) {
                System.out.println("String lock");
           }
        }
    }
    public static Long getFibonacci(Long n) {
        if (n == 1 || n == 2) {
            return 1L;
        } else {
            return getFibonacci(n - 1) + getFibonacci(n - 2);
        }
    }

    public static boolean checkNumber(String... args) {
        for (String s : args) {
            if (!s.matches("^[0-9]+$")) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkDate(String... args) {
        //for (String s : args) {
        //    s.matches()
        //}
        //return true;

        String s = "2001-01-31";
        String regex = "[1-9]([0-9]{3})-(([0][0-9])|([1][0-2]))-(([0][1-9])|([1-2][0-9])|([3][0-1]))";
        System.out.println(s.matches(regex));

        return true;
    }

    public static int method02(int[] nums) {
        int size = nums.length;
        int mid = size / 2;

        while (mid < size && mid >= 0) {
            int left = 0, right = 0;
            for (int i = 0; i < mid; i++) {
                left += nums[i];
            }
            for (int i = mid + 1; i < size; i++) {
                right += nums[i];
            }
            if (left == right) {
                return mid;
            } else if (left > right){
                if (nums[mid] > 0) {
                    mid = mid - 1;
                } else {
                    mid = mid + 1;
                }
            } else {
                if (nums[mid] > 0) {
                    mid = mid + 1;
                } else {
                    mid = mid - 1;
                }
            }
        }
        return -1;
    }

    // 合并区间

    /**
     * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     *
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len == 1) {
            return intervals;
        }
        int[][] arr = new int[len][2];
        int index = -1;
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        for (int i = 0; i < len; i++) {
            if (index == -1 || intervals[i][0] > arr[index][1]) {
                arr[++index][0] = intervals[i][0];
                arr[index][1] = intervals[i][1];
            } else {
                arr[index][1] = Math.max(intervals[i][1], arr[index][1]);
            }
        }

        return Arrays.copyOf(arr, index + 1);
    }
    public static int[][] merge2(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];

            int[] temp = list.get(list.size() - 1);
            if (current[0] > temp[1]) {
                list.add(current);
            } else {
                list.get(list.size() - 1)[1] = Math.max(current[1], temp[1]);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }

    public static int[][] merge3(int[][] intervals) {
        BitSet bitSet = new BitSet();
        return null;
    }


    public static int binaryMethod02(int[] nums, int target) {
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static Integer[] findDiffByMap(int[] strArr, int[] existArr) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < strArr.length; i++) {
            map.put(strArr[i], 1);
        }
        for (int i = 0; i < existArr.length; i++) {
            if (map.containsKey(existArr[i])) {
                map.put(existArr[i], 2);
            } else {
                map.put(existArr[i], 3);
            }
        }
        map.forEach((k, v) -> {
            if (v == 3) {
                list.add(k);
            }
        });
        return list.toArray(Integer[] :: new);
    }

    public static int[] findDiffByBitSet(int[] strArr, int[] existArr) {

        BitSet bitSet = new BitSet(strArr.length + existArr.length);
        for (int i = 0; i < strArr.length; i++) {
            bitSet.set(strArr[i]);
        }

        BitSet bit = new BitSet();
        for (int i = 0; i < existArr.length; i++) {
            if (!bitSet.get(existArr[i])) {
                bit.set(existArr[i]);
            }
        }
        return bit.stream().toArray();
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int low = start;
            int high = end;
            int standard = arr[low];
            while (high > low) {
                while (high > low && arr[high] >= standard) {
                    high--;
                }
                arr[low] = arr[high];
                while (high > low && arr[low] <= standard) {
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = standard;
            quickSort(arr, start, low);
            quickSort(arr, low + 1, end);
        }
    }

    public static void threadRun() {
        long a = 0;
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "\t" + a++);
        }
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //System.out.println(Thread.currentThread().getName()+ Thread.currentThread().getId());
        }, "t1").start();
    }
}
