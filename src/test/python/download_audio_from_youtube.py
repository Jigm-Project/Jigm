import os
import yt_dlp

def download_audio_from_youtube(url):
    # 사용자의 동영상 폴더 경로 가져오기
    video_folder = os.path.join(os.path.expanduser("~"), "Videos")
    
    ydl_opts = {
        'format': 'bestvideo+bestaudio',
        'outtmpl': f'{video_folder}/%(title)s.%(ext)s',  # 동영상 폴더에 저장
        'postprocessors': [{
            'key': 'FFmpegVideoConvertor',
            'preferedformat': 'mp4',  # mp4 포맷으로 변환
        }],
    }

    try:
        with yt_dlp.YoutubeDL(ydl_opts) as ydl:
            ydl.download([url])
        return f"{video_folder}/%(title)s.%(ext)s"  # 다운로드된 파일의 경로를 반환
    except Exception as e:
        print(f"Error downloading video: {e}")
        return None

def main():
    youtube_url = "https://www.youtube.com/watch?v=G8iXlU6Yjqs"
    audio_file_path = download_audio_from_youtube(youtube_url)

    if audio_file_path:
        print(f"Downloaded video saved to: {audio_file_path}")
        # 추가적으로 .war 파일을 실행하거나 다른 작업을 수행할 수 있습니다
    else:
        print("Failed to download audio.")

if __name__ == "__main__":
    main()
