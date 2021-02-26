import HttpRequest from '@/utils/axios'
const baseApi = process.env.VUE_APP_BASE_API
const baseUrl = process.env.VUE_APP_BASE_URL
const axios = new HttpRequest(baseUrl + baseApi)
export default axios

export const postRequest = (url, params) => {
  // const accessToken = localRead('accessToken')
  return axios.request({
    method: 'post',
    url: `${url}`,
    params: params,
    transformRequest: [

    ],
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded'
    }
  })
}

/**
 * post发送json对象
 * @param {*} url
 * @param {*} params
 */
export const postJsonRequest = (url, params) => {
  // const accessToken = localRead('accessToken')
  return axios.request({
    method: 'post',
    url: `${url}`,
    data: params,
    headers: {
    }
  })
}



