<template>
    <div>
        <h1 class= 'title_one'>{{msg}}</h1>
    </div>
</template>

<script>
export default {
    name:'login',
    data() {
        return {
            msg:'这是业主报修页面'
        }
    }
}
</script>

<style>
.title_one{
    text-align: center;
    margin: 0
    }
</style>
