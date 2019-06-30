import Vue from 'vue'

export default {
    getPlansByDate: date => {
        return Vue.axios.get('/plans/get-by-date', { params: { date }});
    },
    createPlan: data => {
        return Vue.axios.post('/plans', data);
    },
    getPlanById: id => {
        return Vue.axios.get(`/plans/${id}`)
    },
    updatePlan: (id, data) => {
        return Vue.axios.put(`/plans/${id}`, data);
    }
}