#### 대화상자
 : 리소스 파일을 이용한 대화상자

 - 예제

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day8/images/1.png" width="20%"></img>| <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day8/images/2.png" width="20%"></img>
 

[코드로 이동](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day8/Lessson_8_0327/app/src/main/java/com/example/lessson_8_0327/example01_dialog/DialogExampleActivity.java)


#### Toast Message
 : 기본 토스트 메세지로, 리소스 파일을 이용한 토스트 메세지

- 기본 예제

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day8/images/3.png" width="20%"></img>

[코드로 이동](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day8/Lessson_8_0327/app/src/main/java/com/example/lessson_8_0327/example02_toast/ToastMessageActivity.java)


- 커스텀 예제

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day8/images/4.png" width="20%"></img>

[코드로 이동](hhttps://github.com/hyejin830/Android_Daily_Study/blob/master/Day8/Lessson_8_0327/app/src/main/java/com/example/lessson_8_0327/example02_toast/CustomToastMessageActivity.java)

#### Android Resource File
 : res 폴더 아래에 있는 여러가지 파일들, 리소스 파일을 따로 관리할 시, 유지보수 용이

1. 종류
```
/res/values/strings.xml	        문자열 지정
/res/values/array.xml	        문자열 배열 지정
/res/values/color.xml	        색상 지정
/res/values/dimens.xml	        크기 지정
/res/drawable		        이미지 파일을 저장하는 곳
/res/layout		        레이아웃 xml파일을 저자하는 곳
/res/menu			메뉴 xml파일을 저장하는 곳
/res/anim			트윈애니매이션용 xml파일을 저장하는 곳
/res/xml			임의로 정의하는 xml파일을 저장하는 곳
/res/raw			각종 원본파일, mp3, exe, txt 등
```
2. 리소스 파일 정의 및 사용

    2.1 문자열

   - /res/values/strings.xml
    ```
        <string name="리소스이름">텍스트</string>
    ```

   - Layout 사용
    ```
        android:text="@string/리소스이름"
    ```

   - Java 사용
    ```
        getString(R.string.리소스이름);
    ```

    2.2 배열

   - /res/values/array.xml
    ```
        <string-array name="리소스 이름">
            <item>아이템1</item>
            <item>아이템2</item>
            <item>아이템3</item>
        </string-array>
    ```
   - Layout 사용

    ```
        android:entires = "@array/리소스 이름"
    ```

    2.3 색상

   - /res/values/colors.xml
    ```
        <color name="리소스 이름">#D81B60</color>
    ```

   - Layout 사용

    ```
        android:background="@colors/리소스이름"
    ```

   - Java 사용

    ```
        getResources().getColor(R.colors.리소스이름);
    ```

    2.4 크기

    #### DPI(Dot Per Inch)
      - 1인치에 들어가는 픽셀을 나타내는 단위
      - 개수가 많을 수록 고밀도
	    ldpi : 120dpi
	    mdpi : 160dpi
	    hdpi : 240dpi
	    xhdpi : 320dpi
	    xxhdpi : 480dpi
	    xxxhdpi : 640dpi

   - /res/values/dimens.xml
    ```
        <dimen name="리소스 이름">
            20dp
        </dimen>
    ```

   - Layout 사용
    ```
    android:textSize="@dimen/리소스 이름"
    ```

   - Java 사용
    ```
        getResources().getDimension(R.dimen.리소스이름);
    ```

3. 이미지 리소스 : 안드로이드에서 사용하는 다양한 아이콘 이미지
- https://material.io/tools/icons/?search=people&style=baseline
- 다운받을 시, dp별이 아닌 android로 변경 후 다운 - 압축파일(해상도 별로 구분)

 <img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day8/images/5.png" width="20%"></img>

[코드로 이동](https://github.com/hyejin830/Android_Daily_Study/blob/master/Day8/Lessson_8_0327/app/src/main/java/com/example/lessson_8_0327/example03_resource/ResourceExampleActivity.java)

