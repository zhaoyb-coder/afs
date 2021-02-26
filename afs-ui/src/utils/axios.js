import axios from 'axios'
class HttpRequest {
  // eslint-disable-next-line no-undef
  constructor(baseUrl = baseURL) {
    this.baseUrl = baseUrl
    this.queue = {}
  }
  getInsideConfig () {
    const config = {
      baseURL: this.baseUrl
    }
    return config
  }
  destroy (url) {
    delete this.queue[url]
    if (!Object.keys(this.queue).length) {
      // Spin.hide()
    }
  }
  interceptors (instance, url) {
    // 请求拦截
    instance.interceptors.request.use(
      config => {
        // 添加全局的loading...
        if (!Object.keys(this.queue).length) {
          // Spin.show() // 不建议开启，因为界面不友好
        }
        this.queue[url] = true
        return config
      },
      error => {
        return Promise.reject(error)
      }
    )
    // 响应拦截
    instance.interceptors.response.use(
      res => {
        this.destroy(url)
        const { data, status } = res
        return { data, status }
      },
      error => {
        this.destroy(url)
        console.log('err' + error)
        return Promise.reject(error)
      }
    )
  }
  request (options) {
    const instance = axios.create({
      withCredentials: true // 跨域请求时发送
      // timeout: 5000 // request timeout
    })
    options = Object.assign(this.getInsideConfig(), options)
    this.interceptors(instance, options.url)
    return instance(options)
  }
}
export default HttpRequest
