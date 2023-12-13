# albert
albert是一个专注于AI领域开发JAVA SDK套件，旨在帮助程序员快速、高效地构建智能AI应用程序。albert is an AI-focused development JAVA SDK suite designed to help programmers build intelligent AI applications quickly and efficiently.
##  TAICHU(太初)
###  1. 介绍
紫东太初2.0是中国科学院自动化研究所在上海发布了该所研制的新一代人工智能大模型。全新大模型相比第一代着力提升了决策与判断能力，实现了从感知、认知到决策的跨越，未来将在医疗、交通、工业生产等领域发挥更大作用。
###  2. maven引用
```
<dependency>
  <groupId>gl.linpeng.ai</groupId>
  <artifactId>albert-taichu-sdk</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>
```
###  3. 使用
```
TaichuClient client = new TaichuClient();
TaichuRequest8B request8B = new TaichuRequest8B();
request8B.setQuestion("你好");
client.invoke(request8B);
```

## YIYAN(一言)
###  1. 介绍
文心一言（英文名：ERNIE Bot）是百度全新一代知识增强大语言模型，文心大模型家族的新成员，能够与人对话互动、回答问题、协助创作，高效便捷地帮助人们获取信息、知识和灵感。文心一言从数万亿数据和数千亿知识中融合学习，得到预训练大模型，在此基础上采用有监督精调、人类反馈强化学习、提示等技术，具备知识增强、检索增强和对话增强的技术优势。
###  2. maven引用
```
<dependency>
  <groupId>gl.linpeng.ai</groupId>
  <artifactId>albert-yiyan-sdk</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>
```

###  3. 使用
```
YiyanClient client = new YiyanClient();
YiyanRequestErnieBot request = new YiyanRequestErnieBot();
Message message = new Message();
message.setContent("你好,请介绍你自己");
List<Message> messages = List.of(message);
request.setMessages(messages);
client.invoke(request);
```

## QINGYAN(清言)
###  1. 介绍
智谱清言，是北京智谱华章科技有限公司推出的生成式AI助手，可在工作、学习和日常生活中为用户解答各类问题，完成各种任务。智谱清言基于智谱AI自主研发的中英双语对话模型ChatGLM2，经过万亿字符的文本与代码预训练，并采用有监督微调技术，以通用对话的形式为用户提供智能化服务。

###  2. maven引用
```
<dependency>
  <groupId>gl.linpeng.ai</groupId>
  <artifactId>albert-qingyan-sdk</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>
```

###  3. 使用
```
QingyanClient client = new QingyanClient();
QingyanChatGlmTurboRequest request = new QingyanChatGlmTurboRequest();
List<Message> messages = new ArrayList<>(1);
Message message = new Message("user", "你好");
messages.add(message);
request.setPrompt(messages);
client.invoke(request);
```

## QIANWEN(千问)[TODO]
###  1. 介绍
通义千问，是阿里云推出的一个超大规模的语言模型，功能包括多轮对话、文案创作、逻辑推理、多模态理解、多语言支持。能够跟人类进行多轮的交互，也融入了多模态的知识理解，且有文案创作能力，能够续写小说，编写邮件等。
###  2. maven引用
```
<dependency>
  <groupId>gl.linpeng.ai</groupId>
  <artifactId>albert-qianwen-sdk</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>
```

## WUKONG(悟空)[TODO]
###  1. 介绍
小悟空原是字节跳动推出的综合类搜索引擎“悟空搜索”，现已更名并转型为AI对话助手和个人助理。通过与小悟空对话，可以看出其内核是与字节此前推出的 豆包 AI聊天机器人同款，但相比豆包提供了更多开箱即用的预设工具，支持智能对话和多种内容创作功能。
###  2. maven引用
```
<dependency>
  <groupId>gl.linpeng.ai</groupId>
  <artifactId>albert-wukong-sdk</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>
```
## 其他
###  其他SDK
- 腾讯混元
- 科大讯飞星火
- 百川大模型
- Kimi Chat
