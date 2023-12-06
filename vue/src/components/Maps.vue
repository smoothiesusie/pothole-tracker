<!-- <template>
    <div id="map" style="height: 400px; width: 100%;"></div>
</template>

  <script>
  
  
  export default {
    name: 'Maps',
    mounted() {
      this.initMap();
    },


    methods: {
      async initMap() {
        const loader = new Loader({
          apiKey: "YOUR_API_KEY", 
          version: "weekly",
         
        });
  
        try {
          await loader.load();
          this.map = new google.maps.Map(document.getElementById("map"), {
            center: { lat: -34.397, lng: 150.644 },
            zoom: 8,
          });
        } catch (error) {
          console.error("Error loading Google Maps:", error);
        }
      }
    }
  };
  </script>
  
  <style>
  #map {
    height: 100%;
  }
  html, body {
    height: 100%;
    margin: 0;
    padding: 0;
  }
  </style> -->
 
 
 
  <template>
    <GoogleMap api-key="AIzaSyBecan41m3EpaUjgHsf4QnYHDuuJ9HpZ_M" style="width: 100%; height: 500px" :center="center" :zoom="15">
      <Marker :options="{ position: center }" />
    </GoogleMap>
  </template>
  
  <script>
  import { defineComponent } from "vue";
  import { GoogleMap, Marker } from "vue3-google-map";
  
  export default defineComponent({
    components: { GoogleMap, Marker },
    setup() {
      const center = { lat: 40.689247, lng: -74.044502 };
  
      return { center };
    },
  });
  </script>

