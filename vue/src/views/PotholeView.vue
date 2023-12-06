<template>
    <div>
      <AddPothole />


    </div>
  </template>
  <script>
   import AddPothole from '../components/AddPothole.vue'
   import Maps from '../components/Maps.vue';
  export default {
    components: {
       AddPothole,
       
    },

    methods : {
      handlePotholeAdded(potholeLocation){
        this.$refs.mapComponent.addMarker(potholeLocation);
      }
    }
  };
  </script>