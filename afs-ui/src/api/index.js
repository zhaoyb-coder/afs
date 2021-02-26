import {
  postRequest,
  postJsonRequest
} from '@/utils/api.request'

const URI = 'house'

export const fetchData = params => {
  return postRequest(`${URI}/pagelist`, params)
};
export const fetchMonthrent = params => {
  return postRequest(`${URI}/monthrent/list`, params)
};
export const addHouse = params => {
  return postJsonRequest(`${URI}/add`, params)
};
export const editHouse = params => {
  return postJsonRequest(`${URI}/update`, params)
};
export const delHouse = params => {
  return postRequest(`${URI}/delete`, params)
};
