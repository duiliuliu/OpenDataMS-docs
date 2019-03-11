> 前端设计

前端整体使用[ReactJs](https://react.docschina.org/)全家桶(redux,redux-actions,redux-sagas,immutable.js,react-router)进行开发，UI库使用阿里[AntDesign](https://ant.design/index-cn)

- [首页设计](./index.md)
- [任务设计](./job.md)
- [函数设计](./function.md)
- [数据设计](./data.md)

**接口遵循Rest规范**

## 命名

react action命名：
- 请求数据： REQUEST_*
- 加载数据： LOAD_*
- 获取数据： FETCH_*

- 提交form表单为 SUBMIT_*

- 错误请求： ERROR
- 成功请求： SUCCESS

- [ ] job
  - [ ] newJob
    - [ ] newCollectJob
      - [x] collectCityList 城市下拉列表数据
      - [x] collectDataList 数据项下拉列表数据
      - [x] collectCityStatus
      - [x] collectDataStatus
    - [ ] newCleanJob
      - [x] cleanCityList
      - [x] cleanDataList
      - [x] cleanCityStatus
      - [x] cleanDataStatus
      - [ ] funtionList 函数下拉列表数据
      - [ ] dataColList 数据列下拉列表数据
      - [ ] functionStatus
      - [ ] dataColStatus
  - [ ] currentJob
    - [ ] job
      - [ ] 如下，job对象
      - [ ] 多一个进度条 jobPercent
  - [ ] managerJob
    - [ ] job
      - [ ] jobId 根据ID拉取详情config
      - [ ] jobStatus
      - [ ] jobName
      - [ ] jobDatas  datas下载成功后每个data对象有相应的path
      - [ ] jobCreator
      - [ ] jobCreated
      - [ ] jobCompleted
      - [ ] jobConfig 详情config，比



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
    errorMessage: ""
  }

- user 对象
  ```
  user {
    id long
    name string
    gender byte
    photo String（path）
    - [ ] 其他
  }
  ```

- job 对象
  ```
  {
    id long
    type 枚举值 COLLECT or CLEAN
    status  枚举值
    name string
    datas arrayof(data对象)
    creator String
    created date 数据库可用timestamp，插入时触发
    completed date 数据库可用timestamp，更新状态时触发
    config
  }
  ```
- data 对象
  ```
  name string
  path
  size
  ```


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

## 开发设计

公共组件功能开发

- [ ] component 
  - [ ] Router
  - [ ] Menu
  - [ ] Layout
  - [ ] message
  - [ ] 404page
  - [ ] errorpage
- [ ] redux
  - [ ] action
    - [ ] errorAction
- [ ] util
  - [ ] StringUtil

### component
### redux
### util