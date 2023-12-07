<!-- <template>
    <div>
      <AddPothole @potholeAdded="handlePotholeAdded" />
<Maps ref="mapComponent" />

    </div>
  </template>
  <script>
   import AddPothole from '../components/AddPothole.vue'
   import Maps from '../components/Maps.vue';
  export default {
    components: {
       AddPothole,
       Maps
    },

    methods : {
      handlePotholeAdded(potholeLocation){
        this.$refs.mapComponent.addMarker
      }
    }
  };
  </script> -->


  <template>
    <div>
      <AddPothole @potholeAdded="handlePotholeAdded" />
      <Maps :markers="markers" />
    </div>
  </template>
  
  <script>
  import AddPothole from '../components/AddPothole.vue';
  // import Maps from '../components/Maps.vue';
  
  export default {
    components: {
      AddPothole,
      // Maps
    },
    data() {
      return {
        markers: [],
      };
    },
    methods: {
      handlePotholeAdded(pothole) {
        const newMarker = {
          id: this.markers.length + 1,
          position: {
            lat: pothole.latitude,
            lng: pothole.longitude,
          },
        };
        this.markers.push(newMarker);
      },
    },
  };
  </script>
  