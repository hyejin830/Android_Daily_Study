
## RecylcerView를 활용한 채팅 액티비티 생성

### 1. MessageModel 선언
   - 보내는 포맷에 맞게 변수 선언 후, getter/setter/constructor/toString 을 생성

### 2. RecyclerView Adapter 생성

```
 @Override
    public void onBindViewHolder(@NonNull MessageViewHolder messageViewHolder, int position) {
        // 오른쪽
        if (messageModels.get(position).getUserName().equals(email_account)) { 
            messageViewHolder.messageTextView.setBackgroundResource(R.drawable.rightbubble);
            messageViewHolder.fromNameTextView.setText(messageModels.get(position).getUserName());
            messageViewHolder.messageTextView.setText(messageModels.get(position).getMessage());
            LinearLayout.LayoutParams layoutParams =
                    new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.gravity = Gravity.RIGHT;
            messageViewHolder.messageItemDestinationLinearLayout.setLayoutParams(layoutParams);
        } else { // 왼쪽
            messageViewHolder.messageTextView.setBackgroundResource(R.drawable.leftbubble);
            messageViewHolder.fromNameTextView.setText(messageModels.get(position).getUserName());
            messageViewHolder.messageTextView.setText(messageModels.get(position).getMessage());
            LinearLayout.LayoutParams layoutParams =
                    new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.gravity = Gravity.LEFT;
            messageViewHolder.messageItemDestinationLinearLayout.setLayoutParams(layoutParams);
        }
    }
```

### 3. RecyclerView에 adapter 연결

- 임의로 item 추가

```
private void addArrayListOfMessageModel() {
        messageModelArrayList = new ArrayList<>();
        // user1
        messageModelArrayList.add(new MessageModel(getString(R.string.user_name_1), getString(R.string.user_msg_1)));
        messageModelArrayList.add(new MessageModel(getString(R.string.user_name_1), getString(R.string.user_msg_1)));
        messageModelArrayList.add(new MessageModel(getString(R.string.user_name_1), getString(R.string.user_msg_1)));

        // user2
        messageModelArrayList.add(new MessageModel(getString(R.string.user_name_2), getString(R.string.user_msg_2)));
        messageModelArrayList.add(new MessageModel(getString(R.string.user_name_2), getString(R.string.user_msg_2)));
        messageModelArrayList.add(new MessageModel(getString(R.string.user_name_2), getString(R.string.user_msg_2)));
    }
```

- 사용자가 메세지 입력시, 아래로 스크롤 구현

```
new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewMessageWindowRecyclerView.scrollToPosition(messageRecyclerViewAdapter.getItemCount() - 1);
                    }
                }, 200);
```

<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day18/images/1.png" width="40%"></img>|<img src="https://github.com/hyejin830/Android_Daily_Study/blob/master/Day18/images/2.png" width="40%"></img>

-------------

## token 외부 DB 항목에 추가 

- 회원가입 할 때 사용자의 토큰 값 저장
: ALTER TABLE uesrs ADD token varchar(160) not null;

## server 코드와 java 코드 수정