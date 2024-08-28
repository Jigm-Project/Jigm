import os
from download_audio_from_youtube import download_audio_from_youtube

def main():
    # 링크 주입하면 영상 다운로드 < 경로는 사용자 동영상 폴더에 저장
    youtube_url = "https://www.youtube.com/watch?v=G8iXlU6Yjqs"
    video_file_path = download_audio_from_youtube(youtube_url)

    if video_file_path:
        print(f"Downloaded video saved to: {video_file_path}")
        
        # Clova Speech API를 통해 자막 추출
        invoke_clova_speech_api(video_file_path)
    else:
        print("Failed to download video.")

def invoke_clova_speech_api(file_path):
    # 환경 변수에서 API 키와 URL 가져오기
    clova_api_key = os.getenv("CLOVA_SPEECH_API_KEY")
    clova_api_url = os.getenv("CLOVA_SPEECH_API_URL")
    
    if not clova_api_key or not clova_api_url:
        print("API key or URL is not set in environment variables.")
        return
    
    # Java 프로그램 호출 (환경 변수 전달)
    os.system(f'java -jar clova-speech-1.0-SNAPSHOT.war {file_path} --clova.speech.api.key="{clova_api_key}" --clova.speech.api.url="{clova_api_url}"')

if __name__ == "__main__":
    main()
