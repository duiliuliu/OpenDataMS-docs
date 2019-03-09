> 前端设计

前端整体使用[ReactJs](https://react.docschina.org/)全家桶(redux,redux-actions,redux-sagas,immutable.js,react-router)进行开发，UI库使用阿里[AntDesign](https://ant.design/index-cn)

- [首页设计](./index.md)
- [任务设计](./job.md)
- [函数设计](./function.md)
- [数据设计](./data.md)

## 命名

react action命名：
- 请求数据： REQUEST_*
- 加载数据： LOAD_*

- 提交form表单为 SUBMIT_*

- 错误请求： ERROR_*

## 前后端交互数据结构

以json数据传输：
- 成功请求：
  {
    data:{},
    success:true
  }

- 错误请求:
  {
    errorCode: ***
    message: ""
  }


## 技术支持：

| 技术             | 名称                |
| ---------------- | ------------------- |
| React            | 前端框架            |
| React-Redux      | 状态管理            |
| Redux-Sagas      | Redux异步操作中间件 |
| React-Router     | 路由                |
| redux-logger     | 日志                |
| antd             | UI                  |
| moment           | 日期转化            |
| classnames       | 样式控制            |
| eslint、prittier | 代码格式化          |
| esdoc            | 文档                |
